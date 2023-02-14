package com.epsi.srping.mg.demo.controllers;

import com.epsi.srping.mg.demo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.epsi.srping.mg.demo.DataUser;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.epsi.srping.mg.demo.controllers.Constantes.*;

@Controller
@RequestMapping("/users")
public class UserController {
	protected User currentUser = new User();
	private ArrayList<User> database = new ArrayList<>();
	//protected DataUser database;
	public UserController() {
		database.add(new User().setNom("Comrad").setPrenom("Elmo").setId(1));
		database.add(new User().setNom("Jerusalem").setPrenom("Ninnin").setId(2));
		database.add(new User().setNom("Fly").setPrenom("Lord").setId(3));
		database.add(new User().setNom("Croche").setPrenom("Sarah").setId(4));
	}
	
	
	@GetMapping(ROUTE_SHOW)
	public String affichageUser(Model model, @PathVariable("id") int id){
		User rechUtil = this.rechParId(id);
		if (rechUtil != null) {
			model.addAttribute(USER_MODEL, rechUtil);
		}
		return "utilisateurs";
	}
	
	@GetMapping(ROUTE_CREATE)
	public String ajoutUser(Model model, @PathVariable("id") int id){
		
		/*currentUser.setNom("Nom");
		currentUser.setPrenom("Prenom");
		currentUser.setAge(0);*/
		database.add(new User().setId(1).setNom("Comrad").setPrenom("Elmo"));
		database.add(new User().setId(2).setNom("Jerusalem").setPrenom("Ninnin"));
		//nouvUser.setNaissance(LocalDateTime.parse("Date de naissance: yyyy-MM-dd"));
		model.addAttribute(USER_MODEL,currentUser);
		database.add(currentUser);
		return "ajoututilisateur";
	}
	
	@PostMapping(ROUTE_SAVE)
	public String formulaireRempli(@ModelAttribute User utilisateurHydrated,Model model){
		User rechUtil = this.rechParId(utilisateurHydrated.getId());
		if (rechUtil !=null){
			rechUtil.setNom(utilisateurHydrated.getNom());
			rechUtil.setPrenom(utilisateurHydrated.getPrenom());
		}
		return "redirect:/users/"+ rechUtil.getId()+"/utilisateurs";
	}
	@GetMapping(ROUTE_LIST)
	public String listeUtilisateurs(Model model){
		model.addAttribute(USERS_MODEL,database);
		return "liste";
	}
	@GetMapping(ROUTE_MOD)
	public String modifUtilisateur(Model model,@PathVariable("id")int id){
		User rechUtil = this.rechParId(id);
		model.addAttribute(USER_MODEL, rechUtil);
		return "utilisateurs";
	}
	
	private User rechParId(int id){
		User rechUtil = null;
		for (User user: this.database) {
			if (user.getId() == id){
				rechUtil = user;
				break;
			}
		}
		return rechUtil;
	}
}

/*User currentUser= new User();
		currentUser.setPrenom("Elmo");
		currentUser.setNom("Comrad");
		currentUser.setNaissance(LocalDateTime.parse("1994-02-11T13:21:35"));*/