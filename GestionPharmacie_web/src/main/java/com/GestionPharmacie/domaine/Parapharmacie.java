package com.GestionPharmacie.domaine;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="t_Parapharmacie")
@PrimaryKeyJoinColumn(name="idProduit")
public class Parapharmacie extends Produit {
	
	private final Double surtaxe=0.098;
	private int categorie;
	
	
	public Parapharmacie() {
		super();
	}

	
	public Parapharmacie(String nomProduit, Double coutProduit,int categorie, Client client) {
		super(nomProduit, coutProduit, false, client);
		this.setCategorie(categorie);
	}


	public int getCategorie() {
		return categorie;
	}


	public void setCategorie(int categorie) {
		
		if(categorie>=0 && categorie<=4){
			this.categorie = categorie;
		}
		else{
			this.categorie = 0;
		}	
	}

	
	public double getSurtaxe() {
		return surtaxe;
	}
	

}
