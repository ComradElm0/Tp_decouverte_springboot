package com.epsi.srping.mg.demo.controllers;

import com.epsi.srping.mg.demo.Marchandise;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/stock")
public class ObjectController {
	protected ArrayList<Marchandise> stock;
	protected ObjectController() {
		stock = new ArrayList<>();
	}
}
