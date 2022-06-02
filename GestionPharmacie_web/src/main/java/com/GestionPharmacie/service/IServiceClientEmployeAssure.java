package com.GestionPharmacie.service;

import java.util.List;

import com.GestionPharmacie.domaine.ClientEmployeAssure;
import com.GestionPharmacie.domaine.Produit;

public interface IServiceClientEmployeAssure {
	
	public ClientEmployeAssure CreeClientEmployeAssure(ClientEmployeAssure clientEmployeAssure);
	public Double CalculFacture(ClientEmployeAssure clientAssure);
	public List<ClientEmployeAssure>ListClientEmployeAssure();
	public void SupprimerClientEmployeAssure(Long identifiant);
	public void ModifierClientEmployeAssure(ClientEmployeAssure clientEmployeAssure);
	public List<Produit>ListProduitByidClient(Long idClient);
	public ClientEmployeAssure getClientByid(Long identifiant);
	public void addProduitToExistClient(Produit produit,Long idClient);
	public void addAllProduit(List<Produit>Produit);
	public void deleteAllProdByClientEmployeAssure(Long idClient);

}
