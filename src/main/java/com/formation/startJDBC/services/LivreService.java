package com.formation.startJDBC.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.formation.startJDBC.dao.ConnectionMysql;
import com.formation.startJDBC.models.Livre;
import com.formation.startJDBC.repositories.LivreRepository;

public class LivreService implements LivreRepository {

	@Override
	public Optional<Collection<Livre>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Livre> findByID(String id) {
		Livre livre = null;

		try (Connection c = ConnectionMysql.getInstance()) {
			String query = "select * from livre where isbn = ?";
			try (PreparedStatement st = c.prepareStatement(query)) {
				st.setString(1, id);
				try (ResultSet res = st.executeQuery()) {
					while (res.next()) {
						
						livre = new Livre();
						livre.setIsbn(res.getString("isbn"));
						livre.setTitre(res.getString("titre"));
						livre.setAuteur_Nom(res.getString("auteur_nom"));
						livre.setAuteur_Prenom(res.getString("auteur_prenom"));
						livre.setEditeur(res.getString("editeur"));
						livre.setAnnee(res.getInt("annee"));
						
					}
				}
			} catch (SQLException s) {
				s.printStackTrace();
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return Optional.ofNullable(livre);
	}

	@Override
	public int save(Livre objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Livre objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByID(String id) {
		try (Connection c = ConnectionMysql.getInstance()) {
			String query = "DELETE from livre where isbn = ?";
			try (PreparedStatement st = c.prepareStatement(query)) {
				st.setString(1, id);
				return st.executeUpdate();
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return 0;
	}

	@Override
	public Optional<List<Livre>> findByTitle(String titre) {
		// TODO Auto-generated method stub
		return null;
	}

}
