package com.GestionPharmacie.service;

import java.util.List;

import com.GestionPharmacie.domaine.Medicament;
import com.GestionPharmacie.domaine.Parapharmacie;
import com.GestionPharmacie.domaine.Produit;

public interface IServiceProduit {
	
	public void supprimerProduit(Long identifiant);
	public void AddProduit(Produit produit);
	public void ModifierProduit(Produit produit);
	public List<Produit>ListProduit();
	public Produit getProduitById(Long Identifiant);
	public void deleteAllProduct();
	public List<Parapharmacie>AllParapharmacie();
	public List<Medicament>AllMedicament();


}
