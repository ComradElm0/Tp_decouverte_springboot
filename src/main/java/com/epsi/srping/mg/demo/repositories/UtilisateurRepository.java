package com.epsi.srping.mg.demo.repositories;

import com.epsi.srping.mg.demo.entitees.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<User, Integer> {
	List<User> findByNom(String Nom);
	List<User> findByNomAndPrenom(String Nom,String Prenom);
	
}
