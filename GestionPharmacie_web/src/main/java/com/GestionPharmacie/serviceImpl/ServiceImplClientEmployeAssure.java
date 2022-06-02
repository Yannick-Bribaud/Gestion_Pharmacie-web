package com.GestionPharmacie.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GestionPharmacie.domaine.Client;
import com.GestionPharmacie.domaine.ClientEmployeAssure;
import com.GestionPharmacie.domaine.Medicament;
import com.GestionPharmacie.domaine.Parapharmacie;
import com.GestionPharmacie.domaine.Produit;
import com.GestionPharmacie.repository.ClientEmployeAssureRepository;
import com.GestionPharmacie.repository.MedicamentRepository;
import com.GestionPharmacie.repository.ParapharmacieRepository;
import com.GestionPharmacie.repository.ProduitRepository;
import com.GestionPharmacie.service.IServiceClientEmployeAssure;
import com.GestionPharmacie.service.IServiceProduit;


@Service
public class ServiceImplClientEmployeAssure implements IServiceClientEmployeAssure {

	@Autowired
	private ClientEmployeAssureRepository repository;
	@Autowired
	private ProduitRepository ProdRepository;
	@Autowired
	private ParapharmacieRepository ParaRepository;
	@Autowired
	private MedicamentRepository Medirepository;
	@Autowired
	private IServiceProduit serviceProduit;
	
	
	@Override
	public ClientEmployeAssure CreeClientEmployeAssure(ClientEmployeAssure clientEmployeAssure) {
			repository.save(clientEmployeAssure);		
		    return clientEmployeAssure;
	}

	@Override
	public Double CalculFacture(ClientEmployeAssure clientEmplAssure) {
		
		List<Medicament>ProdMed;
		List<Parapharmacie>ProdPara; double couts=0;
		ProdMed=Medirepository.ProduitByClient(clientEmplAssure.getIdClient());
		ProdPara=ParaRepository.ProduitByClient(clientEmplAssure.getIdClient());
		
		if(!ProdMed.isEmpty()){
			for(int i=0; i<ProdMed.size(); i++){
			  couts=couts+ProdMed.get(i).getCoutProduit()	;
			}
			couts=couts-(couts * clientEmplAssure.getRemise());
		}
		
		if(!ProdPara.isEmpty()){
		for(int i=0; i<ProdPara.size(); i++){
			couts=couts+ProdPara.get(i).getCoutProduit();
		 }
	}
		return couts;
	}

	@Override
	public List<ClientEmployeAssure> ListClientEmployeAssure() {
		return repository.findAll();
	}

	@Override
	public void SupprimerClientEmployeAssure(Long identifiant) {
		repository.deleteById(identifiant);
	}

	@Override
	public void ModifierClientEmployeAssure(ClientEmployeAssure clientEmployeAssure) {
		    ClientEmployeAssure client;
			client=getClientByid(clientEmployeAssure.getIdClient());
			BeanUtils.copyProperties(clientEmployeAssure, client);
			repository.saveAndFlush(client);
	}

	@Override
	public List<Produit> ListProduitByidClient(Long idClient) {
		return ProdRepository.ProduitByClientAssure(idClient);
	}

	@Override
	public ClientEmployeAssure getClientByid(Long identifiant) {
		   ClientEmployeAssure clientEmpAss=new ClientEmployeAssure();
		   ClientEmployeAssure client=null;
		   
		   Optional<ClientEmployeAssure>OptionalClient=repository.findById(identifiant);
			if(OptionalClient.isPresent()) {
				client=OptionalClient.get();
				BeanUtils.copyProperties(client, clientEmpAss);
				return clientEmpAss;
			}
		  return null;
	}

	@Override
	public void addProduitToExistClient(Produit produit, Long idClient) {
		Client client=getClientByid(idClient);
		if(client!=null){
		  produit.setClient(client);
		  ProdRepository.save(produit);
	    }
	}

	@Override
	public void addAllProduit(List<Produit> Produit) {
		 ProdRepository.saveAll(Produit);
		
	}

	@Override
	public void deleteAllProdByClientEmployeAssure(Long idClient) {
		
		List<Produit>Product=ListProduitByidClient(idClient);
		for(int i=0; i<Product.size(); i++){
			serviceProduit.supprimerProduit(Product.get(i).getIdProduit());
		}
		SupprimerClientEmployeAssure(idClient);
		
	}



}
