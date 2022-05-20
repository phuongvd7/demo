package training.io.demospringboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import training.io.demospringboot.entity.Bill;
import training.io.demospringboot.entity.User;
import training.io.demospringboot.repository.BillRepo;
import training.io.demospringboot.repository.UserRepo;

@Controller
@RequestMapping("/bill")
public class BillController {
	private static Logger logger = LoggerFactory.getLogger(BillController.class);
	@Autowired
	BillRepo billRepo;
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/create")
	public String create(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("usersss",listUsers);
		return "bill/create";
	}
	@PostMapping("create")
	public String create(@ModelAttribute User user, 
			@ModelAttribute("bill") @Valid Bill bill,BindingResult bindingresult) {
		
		if (bindingresult.hasErrors()) {
			return "bill/create";
		}
	bill.setBuyDate(new java.util.Date());
	billRepo.save(bill)	;
	return "redirect:/bill/search";
}
	@GetMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		Bill bill = billRepo.getById(id);
		model.addAttribute("bill",bill);
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("usersss", listUsers);
		return "bill/update.html";
	}
	@PostMapping("/update")
	public	String update(@ModelAttribute Bill bill,Model model) {
		billRepo.save(bill);
		return "redirect:/bill/search";
		}
	
	@GetMapping("/delete") // ?id=12
	public String delete(@RequestParam("id") int id) {
		userRepo.deleteById(id);
		return "redirect:/bill/search";// url maping
	}
		@GetMapping("/search")
		public	String search(@ModelAttribute Bill bill,Model model) {
			billRepo.save(bill);
			return "redirect:/bill/search";
			}
		
		
		
		
		
		
		
		
		
		
		
}
