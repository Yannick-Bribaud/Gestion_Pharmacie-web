package com.GestionPharmacie.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionPharmacie.domaine.Medicament;
import com.GestionPharmacie.domaine.Parapharmacie;
import com.GestionPharmacie.domaine.Produit;
import com.GestionPharmacie.repository.MedicamentRepository;
import com.GestionPharmacie.repository.ParapharmacieRepository;
import com.GestionPharmacie.repository.ProduitRepository;
import com.GestionPharmacie.service.IServiceProduit;


@Service
public class ServiceImpProduit implements IServiceProduit {

	
	@Autowired
	private ProduitRepository ProdRepository;
	@Autowired
	private ParapharmacieRepository ParaRepository;
	@Autowired
	private MedicamentRepository Medirepository;
	
	
	@Override
	public void supprimerProduit(Long identifiant) {
		
		Optional<Medicament>OptionalMedicament=Medirepository.findById(identifiant);
		Optional<Parapharmacie>OptionalParapharmacie=ParaRepository.findById(identifiant);
		
		if(OptionalMedicament.isPresent()){
		   Medirepository.deleteById(identifiant); 
		}
		if(OptionalParapharmacie.isPresent()){
		  ParaRepository.deleteById(identifiant);
		}
		
	  }

	@Override
	public void ModifierProduit(Produit produit) {
		Produit Prod;
		Prod=getProduitById(produit.getIdProduit());
		BeanUtils.copyProperties(produit, Prod);
		ProdRepository.saveAndFlush(Prod);
	}

	@Override
	public List<Produit> ListProduit() {
	 return ProdRepository.findAll();
	}

	@Override
	public Produit getProduitById(Long Identifiant) {
		
		 Produit produit=new Parapharmacie();
		 Produit Prod=null;
	    Optional<Produit>OptionalProduit=ProdRepository.findById(Identifiant);
	    
		if(OptionalProduit.isPresent()){
			Prod=OptionalProduit.get();
			BeanUtils.copyProperties(Prod, produit);
			return produit;
		}
	   return null;
	}

	@Override
	public void deleteAllProduct() {
	   Medirepository.deleteAll();
	   ParaRepository.deleteAll();
	}

	@Override
	public void AddProduit(Produit produit) {
		ProdRepository.save(produit);	
	}

	@Override
	public List<Parapharmacie> AllParapharmacie() {
		return ParaRepository.findAll();
	}

	@Override
	public List<Medicament> AllMedicament() {
		return Medirepository.findAll();
	}

}
