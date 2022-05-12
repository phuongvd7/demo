package jmaster.io.demospringboot.controller;

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

import jmaster.io.demospringboot.entity.User;
import jmaster.io.demospringboot.repository.UserRepo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepo userRepo;
	

	@GetMapping("/create")
	public String create() {
		return "user/create";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute User user) {
		
		userRepo.save(user);
		return "redirect:/user/search";
	}

	@GetMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {

		User user = userRepo.getById(id);

		model.addAttribute("user", user);
		return "user/update";
	}

	@PostMapping("/update")

	public String update(@ModelAttribute User user) {
		userRepo.save(user);

		return "redirect:/user/search";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest req, @RequestParam("id") int id) {
		userRepo.deleteById(id);

		return "redirect:/user/search";
	}

	@GetMapping("/search")
	public String search(Model model, @RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {

		if (size == null)
			size = 3; // max records per page
		if (page == null)
			page = 0; // trang hien tai

		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

		if (name != null && !name.isEmpty()) {
			Page<User> pageUser = userRepo.search("%" + name + "%", pageable);
			model.addAttribute("userlist", pageUser.toList()); // model add them thuoc tinh gui sang ben view
			model.addAttribute("totalPage", pageUser.getTotalPages());

		} else {

			// if(s==null) {
			Page<User> pageUser = userRepo.findAll(pageable);
			model.addAttribute("userlist", pageUser.toList());
			model.addAttribute("totalPage", pageUser.getTotalPages());

		}
		model.addAttribute("page", page);
		model.addAttribute("name", name == null ? "" : name);
		model.addAttribute("size", size);
		model.addAttribute("id", id == null ? "" : name);
		return "/user/search";

	}
}
