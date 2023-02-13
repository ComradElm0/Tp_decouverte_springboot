package com.epsi.srping.mg.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TemplateController {
	@GetMapping("/hello/template")
	public String index(Model model) {
		model.addAttribute("username", "Comrad Elmo");
		return "home";
	}
	@GetMapping("/hello/about")
	public String about(){
		return "about";
	}
}
