package com.epsi.srping.mg.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class user {
	public class Fichierutilisateur {
		private String prenom;
		private String nom;
		private int age;
		private String civilitee;
		private Date naissance;
		private Date inscription;
		private Date maj;
	}
	@GetMapping("/users")
	public String user(){
		return "";
	}
	}
}
