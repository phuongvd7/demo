//package training.io.demospringboot.controller;
//
//import java.util.Arrays;
//import javax.servlet.http.HttpServletRequest;
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
//import training.io.demospringboot.entity.Customer;
//import training.io.demospringboot.repository.CustomerRepo;
//
//
//
//@Controller
//@RequestMapping("/customer")
//public class CustomerController {	
//	@Autowired // DI
//	CustomerRepo customerRepo;
//	
//	@GetMapping("/create")
//	public String create(Model model) {
//		model.addAttribute("customer", new Customer()); 
//		return "customer/create";
//}
//	@PostMapping("/create")
//	public String create( 
//			@ModelAttribute Customer customer) {
//		customerRepo.save(customer);
//		return "customer/create";
//	}
//	
//	
//	
//	@GetMapping("/update")
//	public String update(@RequestParam("id") int id, Model model){ 
//		Customer customer = customerRepo.getById(id);
//		model.addAttribute("customer", customer);
//		return "customer/update.html";
//	}
//	
//	@PostMapping("/update")
//	public String update(@ModelAttribute Customer customer) {
//		customerRepo.save(customer);
//		return "redirect:/customer/search";
//	}
//	 
//	@GetMapping("/delete") // ?id=12
//	public String delete(HttpServletRequest req, @RequestParam("id") int id) {
//		customerRepo.deleteById(id);
////		customerRepo.save(customerRepo.getById(id));
//		return "redirect:/customer/search";// url maping
//	}
//	
////	@GetMapping("/search")
////	public String search(Model model, @RequestParam(name = "keywordname", required = false) String s) {
////		if(s == null) {
////			List<Customer> list = customerRepo.findAll();
////			model.addAttribute("customerList", list);
////		} else {
////			List<Customer> list = customerRepo.search("%" + s + "%");
////			model.addAttribute("customerList", list);
////		}
////		return "customer/search";
////}
//
//	@GetMapping("/search")
//	public String search(Model model, @RequestParam(name = "name", required = false) String name,
//			@RequestParam(name = "id", required = false) Integer id,
//			@RequestParam(name = "page", required = false) Integer page,
//			@RequestParam(name = "size", required = false) Integer size) {
//		if (size == null)
//			size = 3;// max records per page
//		if (page == null)
//			page = 0;// trang hien tai
//
//		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
//
//		if (name != null && !name.isEmpty()) {
//			Page<Customer> pageCustomer = customerRepo.search("%" + name + "%", pageable);
//
//			model.addAttribute("list", pageCustomer.toList());
//
//			model.addAttribute("totalPage", pageCustomer.getTotalPages());
//			model.addAttribute("page", page);
//			model.addAttribute("size", size);
//			model.addAttribute("name", name);
//			model.addAttribute("id", id);
//		} else if (id != null) {
//			Customer customer = customerRepo.findById(id).orElse(null);
//			if (customer != null) {
//				model.addAttribute("list", Arrays.asList(customer));
//
//			} else
//				// log
////				logger.info("Id not found");
//
//			model.addAttribute("totalPage", 1);
//			model.addAttribute("page", page);
//			model.addAttribute("size", size);
//			model.addAttribute("name", name);
//			model.addAttribute("id", id);
//		} else {
//			Page<Customer> pageCustomer = customerRepo.findAll(pageable);
//
//			model.addAttribute("list", pageCustomer.toList());
//
//			model.addAttribute("totalPage", pageCustomer.getTotalPages());
//			model.addAttribute("page", page);
//			model.addAttribute("size", size);
//			model.addAttribute("name", name);
//			model.addAttribute("id", id);
//		}
//		return "customer/search";
//	}
//
//
//}