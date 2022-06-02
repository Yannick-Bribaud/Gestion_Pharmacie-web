package com.GestionPharmacie.service;

import java.util.List;

import com.GestionPharmacie.domaine.ClientAssure;
import com.GestionPharmacie.domaine.Produit;


public interface IServiceClientAssure {
	
	public ClientAssure CreeClientAssure(ClientAssure clientAssure);
	public Double CalculFacture(ClientAssure clientAssure);
	public List<ClientAssure>ListClientAssure();
	public void SupprimerClientAssure(Long identifiant);
	public void ModifierClientAssure(ClientAssure clientAssure);
	public List<Produit>ListProduitByidClient(Long idClient);
	public ClientAssure getClientByid(Long identifiant);
	public void addProduitToExistClient(Produit produit,Long idClient);
	public void addAllProduit(List<Produit>Produit);
	public void deleteAllProdByClientAssure(Long idClient);
	
}
