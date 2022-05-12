package jmaster.io.demospringboot.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	DepartmentRepo departmentRepo;

	@GetMapping({ "/create" }) // dung get mapping thi put post get
//	@RequestMapping({ "/create" }) //  dung cai nay cung dc nhung phai chi ro dung phuong thuc gi @RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String create() {
		return "department/create";
	}
	@GetMapping({ "/update" }) // dung get mapping thi put post get
	public String update(@RequestParam("id") int id, Model model) {
		Department department = departmentRepo.getById(id);
		model.addAttribute("department", department);
		return "department/update.html";
	}

	@PostMapping("/update")
//	public String update(@RequestParam("id") int id, @RequestParam("name") String name) { // neu chi can 1 thuoc tinh thoi thi request nhanh hon
	// cach 2
	public String update(@ModelAttribute Department department) { // truong hop can map nhieu thuoc tinh voi nhau thi dung
															// model
		departmentRepo.save(department);
		return "redirect:/department/search";
	}

	@PostMapping("/create")
//	public String create(HttpServletRequest req, Model model,@ModelAttribute Department department, @RequestParam("start_date") String date) throws ParseException{
	public String create(@ModelAttribute Department department) {
//		String id = req.getParameter("id");
//		String name = req.getParameter("name");
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		department.setStartDate(sdf.parse(date));
//
//		System.out.println(id);
//		System.out.println(name);
//		departmentRepo.save(department);
//		req.setAttribute("msg", "them thanh cong!");
//		model.addAttribute("key", id);
//
//		return "department/create";
	department.setStartDate(new java.util.Date());
	departmentRepo.save(department);
	return "rediect:/department/search";
	}

	@GetMapping({ "/delete" }) // dung get mapping thi put post get
	public String delete(HttpServletRequest req, @RequestParam("id") int id) {
		departmentRepo.deleteById(id);
		req.setAttribute("msg", "xoa thanh cong!");
//		String id = req.getParameter("id");
		return "redirect:/department/search"; // urlmaping
	}

	@GetMapping({ "/search" }) // dung get mapping thi put post get
	public String search(Model model, @RequestParam(name = "keyword" , required = false) String s) {
		if (s == null) {
			List<Department> list = departmentRepo.findAll();
			model.addAttribute("list", list);
		} else {
			List<Department> list = departmentRepo.search("%" + s + "%");
			model.addAttribute("list", list);
		}
		return "department/search";
	}

}
