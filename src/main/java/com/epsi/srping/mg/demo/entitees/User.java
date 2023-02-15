package com.epsi.srping.mg.demo.entitees;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
@Data
@Entity
@Table(name="sys_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int id;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false)
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

