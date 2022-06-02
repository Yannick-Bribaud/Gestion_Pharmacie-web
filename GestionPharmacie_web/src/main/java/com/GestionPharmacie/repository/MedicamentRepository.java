package com.GestionPharmacie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GestionPharmacie.domaine.Medicament;
import com.GestionPharmacie.domaine.Produit;

public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
	
	@Query("Select m from Medicament m ")
	public List<Produit>ProduitByClientAssureMedicament(Long identifiant);
	
	@Query("Select m, p from Medicament m, Produit p where m.idProduit=p.idProduit and p.client.idClient= ?1")
	public List<Medicament>ProduitByClient(Long identifiant);
	
	@Query("delete from Produit p where p.idProduit=?1")
	public void DeleteProduit(Long identifiant);
	
}
