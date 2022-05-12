package training.io.demospringboot.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import training.io.demospringboot.entity.Customer;
import training.io.demospringboot.entity.Product;
import training.io.demospringboot.repository.CustomerRepo;
import training.io.demospringboot.repository.ProductRepo;



@Controller
@RequestMapping("/product")
public class ProductController {	
	@Autowired // DI
	ProductRepo productRepo;
	
	@GetMapping("/create")
	public String create() {
		return "product/create";
}
	@PostMapping("/create")
	public String create(@ModelAttribute Product product) {
		productRepo.save(product);
		return "product/search";
	}
	
	
	
	@GetMapping("/update")
	public String update(@RequestParam("id") int id, Model model){ 
		Product product = productRepo.getById(id);
		model.addAttribute("product", product);
		return "product/update.html";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Product product) {
		productRepo.save(product);
		return "redirect:/product/search";
	}
	
	@GetMapping("/delete") // ?id=12
	public String delete(HttpServletRequest req, @RequestParam("id") int id) {
		productRepo.deleteById(id);
//		customerRepo.save(customerRepo.getById(id));
		return "redirect:/product/search";// url maping
	}
	
//	@GetMapping("/search")
//	public String search(Model model, @RequestParam(name = "keywordname", required = false) String s) {
//		if(s == null) {
//			List<Product> list = productRepo.findAll();
//			model.addAttribute("productList", list);
//		} else {
//			List<Product> list = productRepo.search("%" + s + "%");
//			model.addAttribute("productList", list);
//		}
//			
//	
//		return "product/search";


@GetMapping("/search")
public String search(Model model, @RequestParam(name = "name", required = false) String name,
		@RequestParam(name = "id", required = false) Integer id,
		@RequestParam(name = "page", required = false) Integer page,
		@RequestParam(name = "size", required = false) Integer size) {
	if (size == null)
		size = 3;// max records per page
	if (page == null)
		page = 0;// trang hien tai

	Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

	if (name != null && !name.isEmpty()) {
		Page<Product> pageProduct = productRepo.search("%" + name + "%", pageable);

		model.addAttribute("list", pageProduct.toList());

		model.addAttribute("totalPage", pageProduct.getTotalPages());
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("customer_name", name);
		model.addAttribute("customer_id", id);
	} else if (id != null) {
		Product product = productRepo.findById(id).orElse(null);
		if (product != null) {
			model.addAttribute("list", Arrays.asList(product));

		} else
			// log
//			logger.info("Id not found");

		model.addAttribute("totalPage", 1);
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("name", name);
		model.addAttribute("id", id);
	} else {
		Page<Product> pageProduct = productRepo.findAll(pageable);

		model.addAttribute("list", pageProduct.toList());

		model.addAttribute("totalPage", pageProduct.getTotalPages());
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("name", name);
		model.addAttribute("id", id);
	}
	return "product/search";
}	
}