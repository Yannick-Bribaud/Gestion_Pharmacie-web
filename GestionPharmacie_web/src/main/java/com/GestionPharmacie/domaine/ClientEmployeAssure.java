package com.GestionPharmacie.domaine;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_ClientEmployeAssure")
@PrimaryKeyJoinColumn(name="idClient")
public class ClientEmployeAssure extends ClientAssure {
	
	private final Double  remise=0.05;
	
	public ClientEmployeAssure() {
		super();
	}
	
	public ClientEmployeAssure(String nom, String prenom, String sexe, String adresse, String numeroPoliceAssurance,
			String nomAssureur) {
		super(nom, prenom, sexe, adresse, numeroPoliceAssurance, nomAssureur);
	}

	public double getRemise() {
		return remise;
	}
	
}
