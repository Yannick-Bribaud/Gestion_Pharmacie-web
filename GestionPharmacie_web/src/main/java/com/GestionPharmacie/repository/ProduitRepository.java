package com.GestionPharmacie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GestionPharmacie.domaine.Parapharmacie;
import com.GestionPharmacie.domaine.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	@Query("Select p from Produit p where p.client.idClient = ?1 ")
	public List<Produit>ProduitByClientAssure(Long identifiant);
	
	@Query("Select p from Produit p where p.client.idClient = ?1 ")
	public List<Parapharmacie>ProduitByClientAssures(Long identifiant);
	
	@Query("Select p from Produit p where p.idProduit=?1")
	public Produit getProduitById(Long identifiant);
	
	@Query("delete from Produit p where p.idProduit=?1")
	public void DeleteProduit(Long identifiant);
	
	


}
