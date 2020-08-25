package com.formation.startJDBC;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // on a nos getter et setteur
@AllArgsConstructor // on a le constructeur avec tous les parametres 
@NoArgsConstructor // on a le constructeur vide 
public class Livre {

	private String isbn;
	private String titre;
	private String auteur_Nom;
	private String auteur_Prenom;
	private String editeur;
	private int annee;
}
