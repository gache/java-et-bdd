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

	public static Optional<Livre> findByID(String isbn) {
		Optional<Connection> conn = getConnection();
		Livre livre = null;
		if (conn.isPresent()) {
			try (Connection c = conn.get()) {
				String query = "select * from livre where isbn = ?";
				try (PreparedStatement st = c.prepareStatement(query)) {
					st.setString(1, isbn);
					try (ResultSet res = st.executeQuery()) {
						while (res.next()) {
							livre = new Livre();
							livre.setIsbn(res.getString("isbn"));
							livre.setTitre(res.getString("titre"));
							livre.setAuteur_Nom(res.getString("auteur_nom"));
							livre.setAuteur_Prenom(res.getString("auteur_prenom"));
							livre.setEditeur(res.getString("editeur"));
							livre.setAnnee(res.getInt("annee"));
							return Optional.ofNullable(livre);
						}
					}
				} catch (SQLException s) {
					s.printStackTrace();
				}
			} catch (SQLException s) {
				s.printStackTrace();
			}
		}
		return Optional.ofNullable(livre);
	}

	public static int deleteByID(String isbn) {
		Optional<Connection> conn = getConnection();
		if (conn.isPresent()) {
			try (Connection c = conn.get()) {
				String query = "DELETE from livre where isbn = ?";
				try (PreparedStatement st = c.prepareStatement(query)) {
					st.setString(1, isbn);
					return st.executeUpdate();
				}
			} catch (SQLException s) {
				s.printStackTrace();
			}
		}
		return 0;
	}

	public static int add(Livre livre) {
		Optional<Connection> conn = getConnection();

		if (conn.isPresent()) {
			try (Connection c = conn.get()) {
				String query = "INSERT into livre values(?,?,?,?,?,?)";
				try (PreparedStatement st = c.prepareStatement(query)) {
					st.setString(1, livre.getIsbn());
					st.setString(2, livre.getTitre());
					st.setString(3, livre.getAuteur_Nom());
					st.setString(4, livre.getAuteur_Prenom());
					st.setString(5, livre.getEditeur());
					st.setInt(6, livre.getAnnee());

					return st.executeUpdate();

				}

			} catch (SQLException s) {
				s.printStackTrace();
			}
		}

		return 0;
	}

	public static void main(String[] args) {

		Livre livre = new Livre(" 978-2070368228", " 1984", "george", "orwell", "Gallimard", 1972);

		int nb = add(livre);
		System.out.println(nb + "row(s) insert");

		Optional<Livre> livre1 = findByID(livre.getIsbn());
		if (livre1.isPresent()) {
			System.out.println(livre1.get());
		}

		nb = deleteByID(livre.getIsbn());
		System.out.println(nb + "row(s) delete");

	}

}
