package com;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dao.VilleFranceDAO;

@SpringBootApplication
public class App 
{
    public static void main( String[] args ) {
    	try {
	        SpringApplication.run(App.class, args);
	        System.out.println("Application démarée !");
    	} catch (Exception e) {
    		System.out.println("Application erreur \n" + e);
    	}
    	/*
    	VilleFranceDAO villeFranceDAO = new VilleFranceDAO();

		VilleFrance villeFrance = new VilleFrance();
		villeFrance.setCodeCommuneINSEE(null);
		villeFrance.setNomCommune(null);
		villeFrance.setCodePostal(null);
		villeFrance.setLibelleAcheminement(null);
		villeFrance.setLigne5(null);
		villeFrance.setLatitude(null);
		villeFrance.setLongitude(null);
		
		List<VilleFrance> villesFrance = villeFranceDAO.trouver(villeFrance);
    	for(int i = 0; i < villesFrance.size(); i++) {
    		System.out.println(villesFrance.get(i));
    	}
    	*/
    }
}
