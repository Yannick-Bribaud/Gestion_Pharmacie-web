package com.GestionPharmacie.domaine;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_ClientAssures")
@PrimaryKeyJoinColumn(name="idClient")
public class ClientAssure extends Client {

	private String numeroPoliceAssurance; 
	private String nomAssureur;
	
	public ClientAssure() {
		super();
		
	}

	public ClientAssure(String nom, String prenom, String sexe, String adresse,String numeroPoliceAssurance, String nomAssureur) {
		super(nom, prenom, sexe, adresse);
		this.numeroPoliceAssurance = numeroPoliceAssurance;
		this.nomAssureur = nomAssureur;	
	}

	public String getNumeroPoliceAssurance() {
		return numeroPoliceAssurance;
	}

	public void setNumeroPoliceAssurance(String numeroPoliceAssurance) {
		this.numeroPoliceAssurance = numeroPoliceAssurance;
	}

	public String getNomAssureur() {
		return nomAssureur;
	}

	public void setNomAssureur(String nomAssureur) {
		this.nomAssureur = nomAssureur;
	}
	
}
