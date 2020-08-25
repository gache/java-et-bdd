package com.formation.startJDBC.dao;

import java.util.Collection;
import java.util.Optional;

public interface CRUD<M, ID> {

	Optional<Collection<M>> findAll();

	Optional<M> findByID(ID id);

	int save(M objet);

	int delete(M objet);

	int deleteByID(ID id);

	/*
	 * C: Create; R: Read; U: Update; D: Delete;
	 * 
	 */
}
