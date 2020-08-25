package com.formation.startJDBC.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionMysql {
	
	private static String url;
	private static String login;
	private static String password;


	private static void getProperties() {
		
		// elle repatrie les information de mon fichier conf.properties
		Properties props = new Properties();

		try (FileInputStream fis = new FileInputStream("conf.properties")) {
			props.load(fis);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	
		url = props.getProperty("jdbc.url");
		login = props.getProperty("jdbc.login");
		password = props.getProperty("jdbc.password");
	}
	// connection à la base de donnée
	
	private static Connection connect;
	
	public static Connection getInstance() {
		if(connect == null) {
			getProperties();
			try {
				connect = DriverManager.getConnection(url, login, password);
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}
		return connect;
	}

}
