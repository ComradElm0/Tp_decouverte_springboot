package com.epsi.srping.mg.demo;

import lombok.Data;
import com.epsi.srping.mg.demo.User;
import java.util.ArrayList;

@Data
public class DataUser {
	private ArrayList<User> database ;
	
	public DataUser() {
		this.database = new ArrayList<>();
	}
	public void addUtilisateur( User user){
		user.setId(database.size()+1);
		database.add(user);
	}
}
