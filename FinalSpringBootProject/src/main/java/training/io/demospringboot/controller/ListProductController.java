//package training.io.demospringboot.controller;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import training.io.demospringboot.entity.ListProduct;
//import training.io.demospringboot.repository.CustomerRepo;
//import training.io.demospringboot.repository.ListProductRepo;
//import training.io.demospringboot.repository.ProductRepo;
//
//
//@Controller
//@RequestMapping("/listproduct")
//public class ListProductController {
//	@Autowired
//	ListProductRepo listProductRepo;
//	@Autowired
//	CustomerRepo customerRepo;
//	
//	@Autowired
//	ProductRepo productRepo;
//	
//	@GetMapping("/create")
//	public String create(Model model) {
//		model.addAttribute("listCustomer", customerRepo.findAll());
//		model.addAttribute("listProduct", productRepo.findAll());
//		return "listproduct/create";
//}
//	@PostMapping("/create")
//	public String create(@ModelAttribute ListProduct listProduct, @RequestParam("customer") int idCustomer,
//			@RequestParam("product") int idProduct) {
//		double price = productRepo.getById(idProduct).getPrice() * listProduct.getQuantity();
//				
//		listProduct.setPrice(price);
//		listProduct.setCustomer(customerRepo.getById(idCustomer));
//		listProduct.setProduct(productRepo.getById(idProduct));
//		listProductRepo.save(listProduct);
//		return "redirect:/listproduct/search";
//	}
//	@GetMapping("/update")
//	public String update(Model model, @ModelAttribute ListProduct listProduct ) {
//		model.addAttribute("listCustomer", customerRepo.findAll());
//		model.addAttribute("listProduct", productRepo.findAll());
//		model.addAttribute("productOrder", listProductRepo.getById(listProduct.getId()));
//		return "listproduct/update";
//	}
//
//	@PostMapping("/update")
//	public String update(@ModelAttribute ListProduct listProduct, @RequestParam("customer") int customerId,
//			@RequestParam("product") int productId) {
//		double price = productRepo.getById(productId).getPrice() * listProduct.getQuantity();
//		listProduct.setPrice(price);
//		listProduct.setCustomer(customerRepo.getById(customerId));
//		listProduct.setProduct(productRepo.getById(productId));
//		listProductRepo.save(listProduct);
//		return "redirect:/listproduct/search";
//	}
//	@GetMapping("/search")
//	public String search(Model model, @RequestParam(name = "id", required = false) Integer id,
//			@RequestParam(name = "name", required = false) String name,
//			@RequestParam(name = "page", required = false) Integer page,
//			@RequestParam(name = "size", required = false) Integer size,
//			@RequestParam(name = "sort", required = false) Integer sort,
//			@RequestParam(name = "customerId", required = false) Integer customerId) {
//
//		if (size == null)
//			size = 3;
//
//		if (page == null)
//			page = 0;
//		
//		if (sort == null) {
//			Pageable pageable = PageRequest.of(page, size, Sort.by("customer.name").ascending());
//			if (name != null && !name.isEmpty()) {
//				Page<ListProduct> pageListProduct = listProductRepo.searchByName("%" + name + "%", pageable);
//				model.addAttribute("list", pageListProduct.toList());
//				model.addAttribute("totalPage", pageListProduct.getTotalPages());
//			} else if (id != null) {
//				ListProduct listProduct = listProductRepo.findById(id).orElse(null);
//				if (listProduct != null) {
//					model.addAttribute("list", Arrays.asList(listProduct));
//				}
//				model.addAttribute("totalPage", 0);
//
//			} else if (customerId != null) {
//				Page<ListProduct> pageListProduct = listProductRepo.searchById(customerId, pageable);
//				model.addAttribute("list", pageListProduct.toList());
//				model.addAttribute("totalPage", pageListProduct.getTotalPages());
//			} else {
//				Page<ListProduct> pageListProduct = listProductRepo.findAll(pageable);
//				model.addAttribute("list", pageListProduct.toList());
//				model.addAttribute("totalPage", pageListProduct.getTotalPages());
//			}
//
//		} else if (sort == 1) {
//			Pageable pageable = PageRequest.of(page, size, Sort.by("customer.name").ascending());
//			if (name != null && !name.isEmpty()) {
//				Page<ListProduct> pageListProduct = listProductRepo.searchByName("%" + name + "%", pageable);
//				model.addAttribute("list", pageListProduct.toList());
//				model.addAttribute("totalPage", pageListProduct.getTotalPages());
//			} else if (id != null) {
//				ListProduct listProduct = listProductRepo.findById(id).orElse(null);
//				if (listProduct != null) {
//					model.addAttribute("list", Arrays.asList(listProduct));
//				}
//				model.addAttribute("totalPage", 0);
//
//			} else if (customerId != null) {
//				Page<ListProduct> pageListProduct = listProductRepo.searchById(customerId, pageable);
//				model.addAttribute("list", pageListProduct.toList());
//				model.addAttribute("totalPage", pageListProduct.getTotalPages());
//			} else {
//				Page<ListProduct> pageListProduct = listProductRepo.findAll(pageable);
//				model.addAttribute("list", pageListProduct.toList());
//				model.addAttribute("totalPage", pageListProduct.getTotalPages());
//			}
//		} else {
//			Pageable pageable = PageRequest.of(page, size, Sort.by("product").ascending());
//			Page<ListProduct> pageListProduct = listProductRepo.findAll(pageable);
//			model.addAttribute("list", pageListProduct.toList());
//			model.addAttribute("totalPage", pageListProduct.getTotalPages());
//		}
//		model.addAttribute("customer", customerRepo.findAll());
//		model.addAttribute("page", page);
//		model.addAttribute("size", size);
//		model.addAttribute("name", name == null ? "" : name);
//		model.addAttribute("id", id == null ? "" : id);
//		model.addAttribute("sort", sort == null ? "" : sort);
//		model.addAttribute("customerId", customerId == null ? "" : customerId);
//
//		return "listproduct/search";
//	}
//
//	@GetMapping("/delete")
//	public String delete(@RequestParam("id") int id) {
//		listProductRepo.delete(listProductRepo.getById(id));
//		return "redirect:/listproduct/search";
//	}
//
//	
//}