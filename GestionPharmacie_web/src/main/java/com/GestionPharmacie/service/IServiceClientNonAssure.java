package com.GestionPharmacie.service;

import java.util.List;
import com.GestionPharmacie.domaine.ClientNonAssure;
import com.GestionPharmacie.domaine.Produit;

public interface IServiceClientNonAssure {
	
	public ClientNonAssure CreeClientNonAssure(ClientNonAssure clientNonAssure);
	public Double CalculFacture(ClientNonAssure clientNonAssure);
	public List<ClientNonAssure>ListClientNonAssure();
	public void SupprimerClientNonAssure(Long identifiant);
	public void ModifierClientNonAssure(ClientNonAssure clientNonAssure);
	public List<Produit>ListProduitByidClient(Long idClient);
	public ClientNonAssure getClientByid(Long identifiant);
	public void addProduitToExistClient(Produit produit,Long idClient);
	public void addAllProduit(List<Produit>Produit);
	public void deleteAllProdByClientNonAssure(Long idClient);
	
}
