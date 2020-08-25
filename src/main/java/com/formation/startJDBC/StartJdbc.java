package com.formation.startJDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import com.formation.startJDBC.models.Livre;

public class StartJdbc {

	public static void main(String[] args) {

		Livre livre = new Livre(" 978-2070368228", " 1984", "george", "orwell", "Gallimard", 1972);

//		int nb = add(livre);
//		System.out.println(nb + "row(s) insert");
//
//		Optional<Livre> livre1 = findByID(livre.getIsbn());
//		if (livre1.isPresent()) {
//			System.out.println(livre1.get());
//		}
//
//		nb = deleteByID(livre.getIsbn());
//		System.out.println(nb + "row(s) delete");

	}

}
