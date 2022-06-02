package com.GestionPharmacie.serviceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionPharmacie.domaine.Client;
import com.GestionPharmacie.domaine.ClientNonAssure;
import com.GestionPharmacie.domaine.Produit;
import com.GestionPharmacie.repository.ClientNonAssureRepository;
import com.GestionPharmacie.repository.ProduitRepository;
import com.GestionPharmacie.service.IServiceClientNonAssure;
import com.GestionPharmacie.service.IServiceProduit;

@Service
public class ServiceImplClientNonAssure implements IServiceClientNonAssure {
	@Autowired
	private ClientNonAssureRepository repository;
	@Autowired
	private ProduitRepository ProdRepository;
	@Autowired
	private IServiceProduit serviceProduit;
	
	@Override
	public ClientNonAssure CreeClientNonAssure(ClientNonAssure clientNonAssure) {
			   repository.save(clientNonAssure);
		return clientNonAssure;
	}

	@Override
	public Double CalculFacture(ClientNonAssure clientNonAssure) {
		 
		List<Produit>Produits; double couts=0;
		Produits=ListProduitByidClient(clientNonAssure.getIdClient());
		for (int i=0; i<Produits.size(); i++) {
		  couts=couts+Produits.get(i).getCoutProduit();
		}
		clientNonAssure.setRemise(couts);
		return clientNonAssure.getRemise();
	}

	@Override
	public List<ClientNonAssure> ListClientNonAssure() {
		return repository.findAll();
	}

	@Override
	public void SupprimerClientNonAssure(Long identifiant) {
		repository.deleteById(identifiant);
	}

	@Override
	public void ModifierClientNonAssure(ClientNonAssure clientNonAssure) {  
		    ClientNonAssure client;
			client=getClientByid(clientNonAssure.getIdClient());
			BeanUtils.copyProperties(clientNonAssure, client);
			repository.saveAndFlush(client);	
	}

	@Override
	public List<Produit> ListProduitByidClient(Long idClient) {
		return ProdRepository.ProduitByClientAssure(idClient);
	}

	@Override
	public ClientNonAssure getClientByid(Long identifiant) {
		   ClientNonAssure clientNonAss=new ClientNonAssure();
		   ClientNonAssure client=null;
		   Optional<ClientNonAssure>OptionalClient=repository.findById(identifiant);
	
			if(OptionalClient.isPresent()) {
				client=OptionalClient.get();
				BeanUtils.copyProperties(client, clientNonAss);
				return clientNonAss;
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
	public void deleteAllProdByClientNonAssure(Long idClient) {
		 List<Produit>Produit= ListProduitByidClient(idClient);
		  for(int i=0; i<Produit.size(); i++){
				serviceProduit.supprimerProduit(Produit.get(i).getIdProduit());
			}
		   SupprimerClientNonAssure(idClient);	
	}

}
