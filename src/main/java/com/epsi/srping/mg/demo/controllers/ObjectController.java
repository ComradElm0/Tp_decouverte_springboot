package com.epsi.srping.mg.demo.controllers;

import com.epsi.srping.mg.demo.Marchandise;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

import static com.epsi.srping.mg.demo.ConstantesMarchandises.*;

@Controller
@RequestMapping("/stock")
public class ObjectController {
	protected ArrayList<Marchandise> stock;
	protected Marchandise marchandise;
	protected ObjectController() {
		stock = new ArrayList<>();
		marchandise = new Marchandise().setId(1).setNomObjet("Gourdin").setValeur(2);
	}
	@GetMapping(OBJET_SHOW)
	public String afficherUneMarchandise(Model model){
		model.addAttribute(MARCHANDISE_ACTUELLE,marchandise);
		return "afficherObjet";
	}
	@GetMapping(OBJET_ADD)
	public String creationMarchandise(){
		return "";
	}
	@GetMapping(OBJET_DEL)
	public String suppressionMarchandise(){
		return "";
	}
	@GetMapping(STOCK_SHOW)
	public String afficherStock(){
		return "";
	}
	@GetMapping(STOCK_ADD)
	public String ajoutStock(){
		return "";
	}
	@GetMapping(STOCK_DEL)
	public String suppressionStock(){
		return "";
	}
}
