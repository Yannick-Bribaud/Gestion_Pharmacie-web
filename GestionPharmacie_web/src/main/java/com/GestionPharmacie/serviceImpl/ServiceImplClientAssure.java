package com.GestionPharmacie.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionPharmacie.domaine.Client;
import com.GestionPharmacie.domaine.ClientAssure;
import com.GestionPharmacie.domaine.Produit;
import com.GestionPharmacie.repository.ClientAssureRepository;
import com.GestionPharmacie.repository.ProduitRepository;
import com.GestionPharmacie.service.IServiceClientAssure;
import com.GestionPharmacie.service.IServiceProduit;

@Service
public class ServiceImplClientAssure implements IServiceClientAssure {
	
	@Autowired
	private ClientAssureRepository repository;
	
	@Autowired
	private ProduitRepository ProdRepository;
	
	@Autowired
	private IServiceProduit serviceProduit;
	
	@Override
	public ClientAssure CreeClientAssure(ClientAssure clientAssure) {
		   repository.save(clientAssure); 
		   return clientAssure;
	}

	@Override
	public Double CalculFacture(ClientAssure clientAssure) {
		List<Produit>Produits; double couts=0;
		Produits=ListProduitByidClient(clientAssure.getIdClient());
		
		for (int i=0; i<Produits.size(); i++) {
		if(!Produits.get(i).isPrisEncharge()){
		    couts=couts+Produits.get(i).getCoutProduit();
		  }
		}
		return couts;
	}

	@Override
	public List<ClientAssure> ListClientAssure() {
		return repository.findAll();
	}

	@Override
	public void SupprimerClientAssure(Long identifiant) {
		repository.deleteById(identifiant);
	}

	@Override
	public void ModifierClientAssure(ClientAssure clientAssure) {
		   ClientAssure client;
		client=getClientByid(clientAssure.getIdClient());
		BeanUtils.copyProperties(clientAssure, client);
		repository.saveAndFlush(client);	
	}

	@Override
	public List<Produit> ListProduitByidClient(Long idClient) {
		return ProdRepository.ProduitByClientAssure(idClient);
	}

	@Override
	public ClientAssure getClientByid(Long identifiant) {
		  ClientAssure clientAss=new ClientAssure();
		  ClientAssure client=null;
	Optional<ClientAssure>OptionalClient=repository.findById(identifiant);
	
		if(OptionalClient.isPresent()){
			client=OptionalClient.get();
			BeanUtils.copyProperties(client, clientAss);
			return clientAss;
		}
		return null;
	}

	@Override
	public void addProduitToExistClient(Produit produit,Long idClient) {
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
	public void deleteAllProdByClientAssure(Long idClient) {
		List<Produit>Product=ListProduitByidClient(idClient);
		for(int i=0; i<Product.size(); i++){
			serviceProduit.supprimerProduit(Product.get(i).getIdProduit());
		}
		   SupprimerClientAssure(idClient);
	}

	

}
