package com.purvar.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("msg", "Hello Thymeleaf Administrator.");
		return "hello";
	}
}
