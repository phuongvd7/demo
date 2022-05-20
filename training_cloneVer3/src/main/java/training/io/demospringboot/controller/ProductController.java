/**
 * 
 */
package training.io.demospringboot.controller;

import java.util.Arrays;

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

import training.io.demospringboot.entity.Product;
import training.io.demospringboot.repository.ProductRepository;


@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/create")
	public String create() {
		return "product/create";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute Product product) {
		productRepository.save(product);
		return "redirect:/product/search";
	}

	@GetMapping("/search")
	public String search(Model model, @RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {

		if (size == null)
			size = 3;

		if (page == null)
			page = 0;
		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

		if (id != null) {
			Product product = productRepository.findById(id).orElse(null);
			if (product != null) {
				model.addAttribute("list", Arrays.asList(product));
			}
			model.addAttribute("totalPage", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			model.addAttribute("name", name == null ? "" : name);
			model.addAttribute("id", id == null ? "" : id);
		} else if (name != null && !name.isEmpty()) {
			Page<Product> pageProduct = productRepository.searchByName("%" + name + "%", pageable);
			model.addAttribute("list", pageProduct.toList());
			model.addAttribute("totalPage", pageProduct.getTotalPages());
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			model.addAttribute("name", name == null ? "" : name);
			model.addAttribute("id", id == null ? "" : id);
		} else {
			Page<Product> pageProduct = productRepository.findAll(pageable);
			model.addAttribute("list", pageProduct.toList());
			model.addAttribute("totalPage", pageProduct.getTotalPages());
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			model.addAttribute("name", name == null ? "" : name);
			model.addAttribute("id", id == null ? "" : id);
		}
		return "product/search";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		productRepository.delete(productRepository.getById(id));
		return "redirect:/product/search";
	}

	@GetMapping("/update")
	public String update(Model model, @RequestParam("id") int id) {
		model.addAttribute("product", productRepository.getById(id));
		return "product/update";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Product product) {
		productRepository.save(product);
		return "redirect:/product/search";
	}
}
