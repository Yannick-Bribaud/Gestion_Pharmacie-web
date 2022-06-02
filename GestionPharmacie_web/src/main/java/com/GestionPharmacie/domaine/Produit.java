package com.GestionPharmacie.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name="t_Produits")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	private String nomProduit;
	private double coutProduit;
	private boolean prisEncharge;
	@ManyToOne @JoinColumn(name="idClient", nullable = false)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Client client;
	
	public Produit() {
		super();
	}

	public Produit(String nomProduit, double coutProduit, boolean prisEncharge,Client client) {
		this.nomProduit = nomProduit;
		this.coutProduit = coutProduit;
		this.prisEncharge = prisEncharge;
		this.client = client;
	}
	
	public Produit(Long idProduit, String nomProduit, double coutProduit, boolean prisEncharge) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.coutProduit = coutProduit;
		this.prisEncharge = prisEncharge;
	}

	public Long getIdProduit() {
		return idProduit;
	}
	
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	
	public String getNomProduit() {
		return nomProduit;
	}
	
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	
	public double getCoutProduit() {
		return coutProduit;
	}
	
	public void setCoutProduit(double coutProduit) {
		this.coutProduit = coutProduit;
	}
	
	public boolean isPrisEncharge() {
		return prisEncharge;
	}
	
	public void setPrisEncharge(boolean prisEncharge) {
		this.prisEncharge = prisEncharge;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


}
