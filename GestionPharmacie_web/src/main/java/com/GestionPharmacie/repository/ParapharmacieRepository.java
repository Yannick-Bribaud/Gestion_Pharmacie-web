package com.GestionPharmacie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GestionPharmacie.domaine.Parapharmacie;
import com.GestionPharmacie.domaine.Produit;

public interface ParapharmacieRepository extends JpaRepository<Parapharmacie, Long> {
	
	@Query("Select p from Parapharmacie p")
	public List<Produit>ProduitByClientAssureParapharmacie(Long identifiant);
	@Query("Select pa, p from Parapharmacie pa, Produit p where pa.idProduit=p.idProduit and p.client.idClient= ?1")
	public List<Parapharmacie>ProduitByClient(Long identifiant);
	
	@Query("Select p from Produit p where p.client.idClient = ?1 ")
	public List<Parapharmacie>ProduitByClientAssures(Long identifiant);
	
	@Query("delete from Produit p where p.idProduit=?1")
	public void DeleteProduit(Long identifiant);
	
		
	

}
