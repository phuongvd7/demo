package jmaster.io.demospringboot.controller;

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

import jmaster.io.demospringboot.entity.Clazz;
import jmaster.io.demospringboot.repository.ClazzRepo;

@Controller
@RequestMapping("/clazz")
public class ClazzController {

	@Autowired // DI
	ClazzRepo clazzRepo;// null

	@GetMapping("/create")
	public String create() {
		return "clazz/create";
	}

	@PostMapping("/create")
	public String create(Model model, 
			@ModelAttribute Clazz clazz, 
			@RequestParam("start_date") String date)
			throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		clazz.setStartDate(sdf.parse(date));

		clazzRepo.save(clazz);

		model.addAttribute("msg", "Them thanh cong");
		return "clazz/create";
	}

	@GetMapping("/update") // ?id=12
	public String update(@RequestParam("id") int id, Model model) {
		Clazz clazz = clazzRepo.getById(id);
		model.addAttribute("clazz", clazz);
		return "clazz/update.html";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Clazz clazz) {
		clazzRepo.save(clazz);
		return "redirect:/clazz/search";
	}

	@GetMapping("/delete") // ?id=12
	public String delete(HttpServletRequest req, @RequestParam("id") int id) {
		clazzRepo.deleteById(id);

		return "redirect:/clazz/search";// url maping
	}

	@GetMapping("/search")
	public String search(Model model, @RequestParam(name = "keyword", required = false) String s) {
		if (s == null) {
			List<Clazz> list = clazzRepo.findAll();
			model.addAttribute("clazzList", list);
		} else {
			List<Clazz> list = clazzRepo.search("%" + s + "%");
			model.addAttribute("clazzList", list);
		}
		return "clazz/search";
	}
}
