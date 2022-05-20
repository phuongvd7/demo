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

import training.io.demospringboot.entity.ListProduct;
import training.io.demospringboot.repository.CustomerRepository;
import training.io.demospringboot.repository.ListProductRepository;
import training.io.demospringboot.repository.ProductRepository;


@Controller
@RequestMapping("/list-product")
public class ListProductController {
	@Autowired
	ListProductRepository listProductRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("listCustomer", customerRepository.findAll());
		model.addAttribute("listProduct", productRepository.findAll());
		return "listproduct/create";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute ListProduct listProduct, @RequestParam("customer") int idCustomer,
			@RequestParam("product") int idProduct) {
		double price = productRepository.getById(idProduct).getPrice() * listProduct.getQuantity();
		listProduct.setPrice(price);
		listProduct.setCustomer(customerRepository.getById(idCustomer));
		listProduct.setProduct(productRepository.getById(idProduct));
		listProductRepository.save(listProduct);
		return "redirect:/list-product/search";
	}

	@GetMapping("/search")
	public String search(Model model, @RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size,
			@RequestParam(name = "sort", required = false) Integer sort,
			@RequestParam(name = "customerId", required = false) Integer customerId) {

		if (size == null)
			size = 3;

		if (page == null)
			page = 0;

		if (sort == null) {
			Pageable pageable = PageRequest.of(page, size, Sort.by("customer").ascending());
			if (name != null && !name.isEmpty()) {
				Page<ListProduct> pageListProduct = listProductRepository.searchByName("%" + name + "%", pageable);
				model.addAttribute("list", pageListProduct.toList());
				model.addAttribute("totalPage", pageListProduct.getTotalPages());
			} else if (id != null) {
				ListProduct listProduct = listProductRepository.findById(id).orElse(null);
				if (listProduct != null) {
					model.addAttribute("list", Arrays.asList(listProduct));
				}
				model.addAttribute("totalPage", 0);

			} else if (customerId != null) {
				Page<ListProduct> pageListProduct = listProductRepository.searchById(customerId, pageable);
				model.addAttribute("list", pageListProduct.toList());
				model.addAttribute("totalPage", pageListProduct.getTotalPages());
			} else {
				Page<ListProduct> pageListProduct = listProductRepository.findAll(pageable);
				model.addAttribute("list", pageListProduct.toList());
				model.addAttribute("totalPage", pageListProduct.getTotalPages());
			}

		} else if (sort == 1) {
			Pageable pageable = PageRequest.of(page, size, Sort.by("customer").ascending());
			if (name != null && !name.isEmpty()) {
				Page<ListProduct> pageListProduct = listProductRepository.searchByName("%" + name + "%", pageable);
				model.addAttribute("list", pageListProduct.toList());
				model.addAttribute("totalPage", pageListProduct.getTotalPages());
			} else if (id != null) {
				ListProduct listProduct = listProductRepository.findById(id).orElse(null);
				if (listProduct != null) {
					model.addAttribute("list", Arrays.asList(listProduct));
				}
				model.addAttribute("totalPage", 0);

			} else if (customerId != null) {
				Page<ListProduct> pageListProduct = listProductRepository.searchById(customerId, pageable);
				model.addAttribute("list", pageListProduct.toList());
				model.addAttribute("totalPage", pageListProduct.getTotalPages());
			} else {
				Page<ListProduct> pageListProduct = listProductRepository.findAll(pageable);
				model.addAttribute("list", pageListProduct.toList());
				model.addAttribute("totalPage", pageListProduct.getTotalPages());
			}
		} else {
			Pageable pageable = PageRequest.of(page, size, Sort.by("product").ascending());
			Page<ListProduct> pageListProduct = listProductRepository.findAll(pageable);
			model.addAttribute("list", pageListProduct.toList());
			model.addAttribute("totalPage", pageListProduct.getTotalPages());
		}
		model.addAttribute("customer", customerRepository.findAll());
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("name", name == null ? "" : name);
		model.addAttribute("id", id == null ? "" : id);
		model.addAttribute("sort", sort == null ? "" : sort);
		model.addAttribute("customerId", customerId == null ? "" : customerId);

		return "listproduct/search";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		listProductRepository.delete(listProductRepository.getById(id));
		return "redirect:/list-product/search";
	}

	@GetMapping("/update")
	public String update(Model model, @RequestParam("id") int id) {
		model.addAttribute("listCustomer", customerRepository.findAll());
		model.addAttribute("listProduct", productRepository.findAll());
		model.addAttribute("productOrder", listProductRepository.getById(id));
		return "listproduct/update";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute ListProduct listProduct, @RequestParam("customer") int customerId,
			@RequestParam("product") int productId) {
		double price = productRepository.getById(productId).getPrice() * listProduct.getQuantity();
		listProduct.setPrice(price);
		listProduct.setCustomer(customerRepository.getById(customerId));
		listProduct.setProduct(productRepository.getById(productId));
		listProductRepository.save(listProduct);
		return "redirect:/list-product/search";
	}
}
