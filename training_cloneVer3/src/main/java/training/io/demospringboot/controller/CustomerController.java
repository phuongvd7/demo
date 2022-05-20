
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

import training.io.demospringboot.entity.Customer;
import training.io.demospringboot.repository.CustomerRepository;



@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/create")
	public String create() {
		return "customer/create";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute Customer customer) {
		customerRepository.save(customer);
		return "redirect:/customer/search";
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
			Customer customer = customerRepository.findById(id).orElse(null);
			if (customer != null) {
				model.addAttribute("list", Arrays.asList(customer));
			}
			model.addAttribute("totalPage", 0);
			
		} else if (name != null && !name.isEmpty()) {
			Page<Customer> pageCustomer = customerRepository.searchByName("%" + name + "%", pageable);
			model.addAttribute("list", pageCustomer.toList());
			model.addAttribute("totalPage", pageCustomer.getTotalPages());
		} else {
			Page<Customer> pageCustomer = customerRepository.findAll(pageable);
			model.addAttribute("list", pageCustomer.toList());
			model.addAttribute("totalPage", pageCustomer.getTotalPages());
		}
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("name", name == null ? "" : name);
		model.addAttribute("id", id == null ? "" : id);
		return "customer/search";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		customerRepository.delete(customerRepository.getById(id));
		return "redirect:/customer/search";
	}

	@GetMapping("/update")
	public String update(Model model, @RequestParam("id") int id) {
		model.addAttribute("customer", customerRepository.getById(id));
		return "customer/update";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Customer customer) {
		customerRepository.save(customer);
		return "redirect:/customer/search";
	}
}
