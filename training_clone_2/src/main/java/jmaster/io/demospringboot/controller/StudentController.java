package jmaster.io.demospringboot.controller;

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

import jmaster.io.demospringboot.entity.Student;
import jmaster.io.demospringboot.repository.StudentRepo;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired // DI
	StudentRepo studentRepo;// null

	@GetMapping("/create")
	public String create() {
		return "student/create";
	}

	@PostMapping("/create")
	public String create(HttpServletRequest req, Model model) {
		String name = req.getParameter("name");

		Student s = new Student();
		s.setName(name);

		studentRepo.save(s);

		req.setAttribute("msg", "Them Thanh cong!");

		return "student/create";
	}

	@GetMapping("/update") // ?id=12
	public String update(@RequestParam("id") int id, Model model) {
		Student student = studentRepo.getById(id);
		model.addAttribute("student", student);
		return "student/update.html";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Student student) {
		studentRepo.save(student);
		return "redirect:/student/search";
	}

	
	@GetMapping("/delete") // ?id=12
	public String delete(HttpServletRequest req, @RequestParam("id") int id) {
		studentRepo.deleteById(id);
//		req.setAttribute("msg", "Xoa Thanh cong!");

		return "redirect:/student/search";// url maping
	}

	@GetMapping("/search")
	public String search(Model model, @RequestParam(name = "keyword", required = false) String s) {

		if (s == null) {
			List<Student> list = studentRepo.findAll();
			model.addAttribute("studentList", list);
		} else {
			List<Student> list = studentRepo.search("%" + s + "%");
			model.addAttribute("studentList", list);
		}
		return "student/search";
	}
}
