package training.io.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import training.io.demospringboot.service.MailService;

@Controller

public class HomeController {
	@Autowired
	MailService mailService;
	@GetMapping("/home")
	public String home() {
		mailService.sendEmail("ducphuong170498@gmail.com", "test test", "test test");
		System.out.println("testmail");
		return "home.html";
	}
	@GetMapping("/dang-nhap")
	public String login() {
		return "login.html";
	}
}
