package com.formation.startJDBC.repositories;

import java.util.List;
import java.util.Optional;

import com.formation.startJDBC.dao.CRUD;
import com.formation.startJDBC.models.Livre;

public interface LivreRepository extends CRUD<Livre, String> {

	Optional<List<Livre>> findByTitle(String titre);

}
