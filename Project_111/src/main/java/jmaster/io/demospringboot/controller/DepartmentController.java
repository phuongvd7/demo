package jmaster.io.demospringboot.controller;

import java.util.Arrays;

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
import jmaster.io.demospringboot.repository.DepartmentRepo;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired // DI
	DepartmentRepo departmentRepo;// null

	@GetMapping("/create")
	public String create() {
		return "department/create";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute Department department) { //model attribute=> add thang vao doi tuong
		department.setCreatedAt(new java.util.Date());
		departmentRepo.save(department);

		return "redirect:/department/search";
	}

	@GetMapping("/update") // ?id=12
	public String update(@RequestParam("id") int id, Model model) {
		Department department = departmentRepo.getById(id);
		model.addAttribute("department", department);
		return "department/update.html";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Department department) {
		Department oldOne = departmentRepo.getById(department.getId());
		;

		oldOne.setName(department.getName());

		departmentRepo.save(oldOne);
		return "redirect:/department/search";
	}

	@GetMapping("/delete") // ?id=12
	public String delete(@RequestParam("id") int id) {
		departmentRepo.deleteById(id);
		return "redirect:/department/search";// url maping
	}

	@GetMapping("/search")
	public String search(Model model, @RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {

		if (size == null)
			size = 3;// max records per page
		if (page == null)
			page = 0;// trang hien tai

		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

		if (name != null && !name.isEmpty()) {
			Page<Department> pageDatepartment = departmentRepo.search("%" + name + "%", pageable);

			model.addAttribute("list", pageDatepartment.toList());

			model.addAttribute("totalPage", pageDatepartment.getTotalPages());
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			model.addAttribute("name", name);
			model.addAttribute("id", id);
		} else if (id != null) {
			Department department = departmentRepo.findById(id).orElse(null);
			if (department != null) {
				model.addAttribute("list", Arrays.asList(department));

			} else
				// log
				logger.info("Id not found");

			model.addAttribute("totalPage", 1);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			model.addAttribute("name", name);
			model.addAttribute("id", id);
		} else {
			Page<Department> pageDatepartment = departmentRepo.findAll(pageable);

			model.addAttribute("list", pageDatepartment.toList());

			model.addAttribute("totalPage", pageDatepartment.getTotalPages());
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			model.addAttribute("name", name);
			model.addAttribute("id", id);
		}
		return "department/search";
	}
}
