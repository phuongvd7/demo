//package jmaster.io.demospringboot.controller;
//
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
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
//import jmaster.io.demospringboot.entity.Ticket;
//import jmaster.io.demospringboot.repository.TicketRepo;
//
//@Controller
//@RequestMapping("/ticket")
//public class TicketController {
//	@Autowired
//	TicketRepo ticketRepo;
//	
//	@GetMapping("/create")
//	public String create() {
//		return "ticket/create";
//	}
//	@PostMapping("/create")
//	public String create(HttpServletRequest req, @ModelAttribute Ticket ticket, Model model, @RequestParam("start_date") String date)
//			throws ParseException {
//		String id = req.getParameter("id");
//		String name = req.getParameter("name");
//		String phoneNumber = req.getParameter("phoneNumber");
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		ticket.setProcessingTime(sdf.parse(date));
//		ticketRepo.save(ticket);
//		model.addAttribute("msg", "them thanh cong");
//		return "ticket/create";
//	}
//
//	@GetMapping("/update")
//	public String update(@RequestParam("id") int id, Model model) {
//
//		Ticket ticket = ticketRepo.getById(id);
//
//		model.addAttribute("ticket", ticket);
//		return "ticket/update";
//	}
//
//	@PostMapping("/update")
//
//	public String update(@ModelAttribute Ticket ticket) {
//		ticketRepo.save(ticket);
//
//		return "redirect:/ticket/search";
//	}
//
//	@GetMapping("/delete")
//	public String delete(HttpServletRequest req, @RequestParam("id") int id) {
//		ticketRepo.deleteById(id);
//
//		return "redirect:/ticket/search";
//	}
//	@GetMapping("/search")
//	public String search(Model model, @RequestParam(name="keyword", required = false) String s) {
//		if(s==null) {
//		List<Ticket> list = ticketRepo.findAll();
//		model.addAttribute("ticketlist",list);
//		return "/ticket/search";
//	}else {
//		List<Ticket> list =ticketRepo.search("%"+ s + "%");
//		model.addAttribute("ticketlist",list);
//		
//	}return "/ticket/search";
//		
//	}
//
//}