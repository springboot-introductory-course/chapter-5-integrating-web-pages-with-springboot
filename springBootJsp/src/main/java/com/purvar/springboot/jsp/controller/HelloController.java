package com.purvar.springboot.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping("/")
	public String hello(Model model) {
		model.addAttribute("hello", "你好，不建议使用JSP。");
		return "index";
	}
}
