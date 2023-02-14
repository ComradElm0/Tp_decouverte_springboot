package com.epsi.srping.mg.demo.controllers;

import com.epsi.srping.mg.demo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

import static com.epsi.srping.mg.demo.controllers.Constantes.*;

@Controller
@RequestMapping("/users")
public class UserController {
	private User currentUser ;
	public UserController() {
		this.currentUser = new User();
		this.currentUser.setNom("Comrad");
		this.currentUser.setPrenom("Elmo");
	}
	
	
	@GetMapping(ROUTE_SHOW)
	public String index(Model model){
		User currentUser= new User();
		currentUser.setPrenom("Elmo");
		currentUser.setNom("Comrad");
		currentUser.setNaissance(LocalDateTime.parse("1994-02-11T13:21:35"));
		model.addAttribute(USER_MODEL, currentUser);
		return "utilisateurs";
	}
	
	@GetMapping(ROUTE_MOD)
	public String ajoutUser(Model model){
		User nouvUser = new User();
		nouvUser.setNom("Nom");
		nouvUser.setPrenom("Prenom");
		nouvUser.setAge(0);
		//nouvUser.setNaissance(LocalDateTime.parse("Date de naissance: yyyy-MM-dd"));
		model.addAttribute(USER_MODEL,currentUser);
		return "ajoututilisateur";
	}
	
	@PostMapping(ROUTE_SAVE)
	public String formulaireRempli(@ModelAttribute User utilisateurHydrated,Model model){
		model.addAttribute(USER_MODEL,utilisateurHydrated);
		
		return "utilisateurs";
	}
}

/*User currentUser= new User();
		currentUser.setPrenom("Elmo");
		currentUser.setNom("Comrad");
		currentUser.setNaissance(LocalDateTime.parse("1994-02-11T13:21:35"));*/