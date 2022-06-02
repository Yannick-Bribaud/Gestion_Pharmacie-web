package com.GestionPharmacie.domaine;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_ClientNonAssure")
@PrimaryKeyJoinColumn(name="idClient")
public class ClientNonAssure extends Client {
	
	private final  static double  indicateur_remise=50000.0;
	private double remise;
	public ClientNonAssure() {
		super();
	}


	public ClientNonAssure(String nom, String prenom, String sexe, String adresse,double remise) {
		super(nom, prenom, sexe, adresse);
		this.setRemise(remise); 
	}

	
	public double getIndicateur_remise() {
		return indicateur_remise;
	}


	public double getRemise() {
		return remise;
	}


	public void setRemise(double remise) {
		if(remise>=indicateur_remise){
			this.remise = remise-(remise *0.1);
		}
		else{
			this.remise=0.0;
		}
		
	}
	
	
	

}
