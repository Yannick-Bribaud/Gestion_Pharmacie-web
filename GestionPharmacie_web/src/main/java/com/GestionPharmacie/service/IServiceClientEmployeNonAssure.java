package com.GestionPharmacie.service;

import java.util.List;

import com.GestionPharmacie.domaine.ClientEmployeNonAssure;
import com.GestionPharmacie.domaine.Produit;

public interface IServiceClientEmployeNonAssure {

	public ClientEmployeNonAssure CreeClientEmployeNonAssure(ClientEmployeNonAssure clientNonEmployeAssure);
	public Double CalculFacture(ClientEmployeNonAssure clientNonEmployeAssure);
	public List<ClientEmployeNonAssure>ListClientEmployeNonAssure();
	public void SupprimerClientEmployeNonAssure(Long identifiant);
	public void ModifierClientEmployeNonAssure(ClientEmployeNonAssure clientNonEmployeAssure);
	public List<Produit>ListProduitByidClient(Long idClient);
	public ClientEmployeNonAssure getClientByid(Long identifiant);
	public void addProduitToExistClient(Produit produit,Long idClient);
	public void addAllProduit(List<Produit>Produit);
	public void deleteAllProdByClientEmployeNonAssure(Long idClient);
	
}
