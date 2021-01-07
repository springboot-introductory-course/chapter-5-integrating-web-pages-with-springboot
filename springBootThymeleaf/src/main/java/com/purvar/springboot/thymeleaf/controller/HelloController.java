package com.purvar.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping("")
	public String hello() {
		return "index";
	}
	
	@RequestMapping("hello")
	public String hello(Model model) {
		model.addAttribute("msg", "Hello Thymeleaf.");
		return "hello";
	}
	
	@RequestMapping("loginFailure")
	public String failure(Model model) {
		model.addAttribute("msg", "Login Failure.");
		return "hello";
	}
	
	@RequestMapping("about")
	public String about(Model model) {
		model.addAttribute("msg", "About Page.");
		return "hello";
	}
}
