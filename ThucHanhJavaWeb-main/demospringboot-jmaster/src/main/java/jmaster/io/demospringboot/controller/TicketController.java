package jmaster.io.demospringboot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import jmaster.io.demospringboot.entity.Department;
import jmaster.io.demospringboot.entity.Ticket;
import jmaster.io.demospringboot.repository.DepartmentRepo;
import jmaster.io.demospringboot.repository.TicketRepo;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	private static Logger logger = LoggerFactory.getLogger(TicketController.class);

	@Autowired // DI
	TicketRepo ticketRepo;// null

	@Autowired // DI
	DepartmentRepo departmentRepo;// null
	
	@GetMapping("/create")
	public String create(Model model) {
		List<Department> departments = departmentRepo.findAll();
		model.addAttribute("departments", departments);
		
		return "ticket/create";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute Ticket ticket) {
		ticket.setCreatedAt(new java.util.Date());
		ticketRepo.save(ticket);

		return "redirect:/ticket/search";
	}

	@GetMapping("/update") // ?id=12
	public String update(@RequestParam("id") int id, Model model) {
		Ticket ticket = ticketRepo.getById(id);
		model.addAttribute("ticket", ticket);
		
		List<Department> departments = departmentRepo.findAll();
		model.addAttribute("departments", departments);
		
		return "ticket/update.html";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Ticket ticket) {
		Ticket oldOne = ticketRepo.getById(ticket.getTicketId());

		oldOne.setContent(ticket.getContent());
		//set them
		ticketRepo.save(oldOne);
		return "redirect:/ticket/search";
	}

	@GetMapping("/delete") // ?id=12
	public String delete(@RequestParam("id") int id) {
		ticketRepo.deleteById(id);
		return "redirect:/ticket/search";// url maping
	}

	@GetMapping("/search")
	public String search(Model model, 
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "departmentId", required = false) Integer departmentId,
			@RequestParam(name = "fromDate", required = false) String fromDate,
			@RequestParam(name = "toDate", required = false) String toDate,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) throws ParseException {

		if (size == null)
			size = 3;// max records per page
		if (page == null)
			page = 0;// trang hien tai

		Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").ascending());

		if (name != null && departmentId != null
				&& fromDate != null && toDate != null
				&& !fromDate.trim().isEmpty()
				&& !toDate.trim().isEmpty()) {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			Page<Ticket> pageTicket = 
					ticketRepo.searchByAll(departmentId,
							sdf.parse(fromDate),
							sdf.parse(toDate),
							name,
							pageable);

			model.addAttribute("list", pageTicket.toList());
			model.addAttribute("totalPage", pageTicket.getTotalPages());
		} 
		//viet them dieu kien va ham tim kiem vao day
		else {
			Page<Ticket> pageTicket = ticketRepo.findAll(pageable);
			
			model.addAttribute("list", pageTicket.toList());
			model.addAttribute("totalPage", pageTicket.getTotalPages());
		}
		
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("name", name == null ? "" : name);
		model.addAttribute("departmentId", departmentId == null ? "" : departmentId);
		model.addAttribute("fromDate", fromDate == null ? "" : fromDate);
		model.addAttribute("toDate", toDate == null ? "" : toDate);
		
		List<Department> departments = departmentRepo.findAll();
		model.addAttribute("departments", departments);
		
		return "ticket/search";
	}
}