package com.epsi.srping.mg.demo.controllers;

import com.epsi.srping.mg.demo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/users")
public class UserController {
	public static final String USER_MODEL = "current_user";
	@GetMapping("/elmo")
	public String index(Model model){
		User currentUser= new User();
		currentUser.setPrenom("Elmo");
		currentUser.setNom("Comrad");
		currentUser.setNaissance(LocalDateTime.parse("1994-02-11T13:21:35"));
		
		model.addAttribute(USER_MODEL, currentUser);
		return "utilisateurs";
	}
}

