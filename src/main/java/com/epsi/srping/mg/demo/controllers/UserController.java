package com.epsi.srping.mg.demo.controllers;

import com.epsi.srping.mg.demo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static com.epsi.srping.mg.demo.controllers.Constantes.*;

@Controller
@RequestMapping("/users")
public class UserController {
	protected User currentUser ;
	public UserController() {
		this.currentUser= new User();
		this.currentUser.setNom("Comrad");
		this.currentUser.setPrenom("Elmo");
	}
	
	
	@GetMapping(ROUTE_SHOW)
	public String affichageUser(Model model, @PathVariable("id") long id){
		//ajout gestion id
		model.addAttribute(USER_MODEL, currentUser);
		return "utilisateurs";
	}
	
	@GetMapping(ROUTE_CREATE)
	public String ajoutUser(Model model){
		User currentUser = new User();
		currentUser.setNom("Nom");
		currentUser.setPrenom("Prenom");
		currentUser.setAge(0);
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