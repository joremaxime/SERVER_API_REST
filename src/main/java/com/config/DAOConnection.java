package com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.dto.client.VilleFrance;

public class DAOConnection {
	
	public static final String CHEMIN_PROPERTIES = "src/main/resources/application.properties";
	
	public Connection getConnection() throws Exception {
		String[] properties = this.loadProperties();
		Connection connect = null;
		
		String url = properties[0];
		String user = properties[1];
		String pwd = properties[2];
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connect = DriverManager.getConnection(url + "?user=" + user + "&password=" + pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		Statement stmt = connect.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT * FROM ville_france");
		while (rset.next()) {
			VilleFrance ville = new VilleFrance();
			ville.setCodeCommuneINSEE(rset.getString(1));
			ville.setNomCommune(rset.getString(2));
			ville.setCodePostal(rset.getString(3));
			ville.setLibelleAcheminement(rset.getString(4));
			ville.setLigne5(rset.getString(5));
			ville.setLatitude(rset.getString(6));
			ville.setLongitude(rset.getString(7));
			
			//System.out.println(ville.toString());
		}
		
		*/
		return connect;
	}
	
	private String[] loadProperties() throws Exception {
		Properties properties = new Properties();
		String url;
		String user;
		String password;

		FileInputStream fichierProperties = new FileInputStream(CHEMIN_PROPERTIES);

		try {
			properties.load(fichierProperties);
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (FileNotFoundException e) {
			throw new Exception("Fichier non trouvé" + e);
		} catch (IOException e) {
			throw new Exception("Impossible de charger le fichier properties " + CHEMIN_PROPERTIES, e);
		}
		
		return new String[] { url, user, password };
	}
	
}
