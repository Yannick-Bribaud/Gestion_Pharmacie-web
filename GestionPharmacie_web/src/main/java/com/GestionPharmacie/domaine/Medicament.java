package com.GestionPharmacie.domaine;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_Medicament")
@PrimaryKeyJoinColumn(name="idProduit")
public class Medicament extends Produit {

	
	public Medicament() {
		super();
	}
	
	public Medicament(String nomProduit, Double coutProduit, boolean prisEncharge, Client client) {
		super(nomProduit, coutProduit, prisEncharge, client);
		
	}

	
	
	
	
}
