//package training.spingboot.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import training.spingboot.entity.Customer;
//import training.springboot.repository.CustomerRepo;
//
//@Controller
//@RequestMapping("/customer")
//public class CustomerController {	
//	@Autowired // DI
//	CustomerRepo customerRepo;
//	
//	@GetMapping("/create")
//	public String create() {
//		return "customer/create";
//}
//	@PostMapping("/create")
//	public String create( Model model) {
//		return "customer/create";
//	}
//	
//	@GetMapping("/update")
//	public String update(@RequestParam("customer_id") int id, Model model){ 
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
//	public String delete( @RequestParam("customer_id") int id) {
//		customerRepo.deleteById(id);
//	//	customerRepo.save(customerRepo.getById(id));
//		return "redirect:/customer/search";// url maping
//	}
//	
//	@GetMapping("/search")
//	public String search(Model model, @RequestParam(name = "keyword", required = false) String s) {
//		return "customer/search";
//}
//}
