package com.epsi.srping.mg.demo.controllers;

import com.epsi.srping.mg.demo.entitees.User;
import com.epsi.srping.mg.demo.repositories.UtilisateurRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.epsi.srping.mg.demo.controllers.Constantes.*;

@Controller
@RequestMapping("/users")
public class UserController {
	//protected User currentUser = new User();
	//private ArrayList<User> database = new ArrayList<>();
	//protected DataUser database;
	private UtilisateurRepository repository;
	
	public UserController(UtilisateurRepository repository) {
		this.repository = repository;
		
		this.repository.save(new User().setNom("Lécu").setPrenom("Annick"));
		this.repository.save(new User().setNom("Bar").setPrenom("Lenny"));
		this.repository.save(new User().setNom("Croche").setPrenom("Sarah"));
		this.repository.save(new User().setNom("Culé").setPrenom("Allan"));
		this.repository.save(new User().setNom("Pelle").setPrenom("Sarah"));
		this.repository.save(new User().setNom("Tim").setPrenom("Vincent"));
	}
	
	
	@GetMapping(ROUTE_SHOW)
	public String affichageUser(Model model, @PathVariable("id") int id){
		User test = this.repository.findById(id).orElse(new User());
		
		
		model.addAttribute(MODEL_ONE,test);

		return "utilisateurs";
	}
	
	@GetMapping(ROUTE_CREATE)
	public String ajoutUser(Model model){
		
		User rechUtil =this.repository.save(new User().setNom("").setPrenom(""));
		model.addAttribute(MODEL_ONE,rechUtil);
		//this.repository.save(rechUtil);
		return "ajoututilisateur";
	}
	
	@PostMapping(ROUTE_SAVE)
	public String formulaireRempli(@ModelAttribute User utilisateurHydrated,Model model){
		User rechUtil = this.repository.findById(utilisateurHydrated.getId()).orElse(new User());
		if (rechUtil !=null){
			this.repository.save(rechUtil.setNom(utilisateurHydrated.getNom())) ;
			this.repository.save(rechUtil.setPrenom(utilisateurHydrated.getPrenom())) ;
		}
		return "redirect:/users/"+ rechUtil.getId() + "/show";
	}
	@GetMapping(ROUTE_LIST)
	public String listeUtilisateurs(Model model){
		model.addAttribute(MODEL_ALL,this.repository.findAll());
		return "liste";
	}
	
	@GetMapping(ROUTE_MOD)
	public String modifUtilisateur(Model model,@PathVariable("id")int id){
		User rechUtil = this.repository.findById(id).orElse(new User());
		model.addAttribute(MODEL_ONE, rechUtil);
		return "ajoututilisateur";
	}
	@GetMapping(ROUTE_DELETE)
	public String supprimerUtilisateur(Model model,@PathVariable("id")int id){
		User rechUtil = this.repository.findById(id).orElse(new User());
		if (rechUtil !=null){
			this.repository.deleteById(id);
		}
		return "redirect:/users/list";
	}
	/*
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
	*/
}