package com.epsi.srping.mg.demo;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
@Data
public class User {

	SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
	private String prenom;
	private String nom;
	private int age;
	private String civilitee;
	private LocalDateTime naissance;
	private ZonedDateTime creeLe = ZonedDateTime.now();
	private ZonedDateTime maj = ZonedDateTime.now();
	public String fullname() {
		return String.format("%s %s", this.prenom, this.nom.toUpperCase());
	}
}

