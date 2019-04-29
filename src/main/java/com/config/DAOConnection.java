package com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
