package com.GestionPharmacie.domaine;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_ClientEmployeNonAssure")
@PrimaryKeyJoinColumn(name="idClient")
public class ClientEmployeNonAssure extends ClientNonAssure {
	
	  private final double remiseParapharmacie=0.05;
  
	public ClientEmployeNonAssure() {
		super();
	}	
	
	public ClientEmployeNonAssure(String nom, String prenom, String sexe, String adresse, double remise) {
		super(nom, prenom, sexe, adresse, remise);
		
	}
	public double getRemise() {
		return remiseParapharmacie;
	}
	  
	  

}
