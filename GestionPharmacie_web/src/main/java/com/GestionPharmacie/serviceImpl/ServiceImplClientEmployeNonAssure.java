package com.GestionPharmacie.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GestionPharmacie.domaine.Client;
import com.GestionPharmacie.domaine.ClientEmployeNonAssure;
import com.GestionPharmacie.domaine.Produit;
import com.GestionPharmacie.repository.ClientEmployeNonAssureRepository;
import com.GestionPharmacie.repository.ProduitRepository;
import com.GestionPharmacie.service.IServiceClientEmployeNonAssure;
import com.GestionPharmacie.service.IServiceProduit;

@Service
public class ServiceImplClientEmployeNonAssure implements IServiceClientEmployeNonAssure {
	
	@Autowired
	private ClientEmployeNonAssureRepository repository;
	@Autowired
	private ProduitRepository ProdRepository;
	@Autowired
	private IServiceProduit serviceProduit;
	
	
	@Override
	public ClientEmployeNonAssure CreeClientEmployeNonAssure(ClientEmployeNonAssure clientEmployeNonAssure) {
		  repository.save(clientEmployeNonAssure);
		  return clientEmployeNonAssure;
	}

	@Override
	public Double CalculFacture(ClientEmployeNonAssure clientEmployeNonAssure) {
		List<Produit>Produits; double couts=0;
		Produits=ListProduitByidClient(clientEmployeNonAssure.getIdClient());
		for (int i=0; i<Produits.size(); i++) {
		  couts=couts+Produits.get(i).getCoutProduit();
		}
		couts=couts-(couts*clientEmployeNonAssure.getRemise());
		return couts;
	}

	@Override
	public List<ClientEmployeNonAssure> ListClientEmployeNonAssure() {
		   return repository.findAll();
	}

	@Override
	public void SupprimerClientEmployeNonAssure(Long identifiant) {
		repository.deleteById(identifiant);

	}

	@Override
	public void ModifierClientEmployeNonAssure(ClientEmployeNonAssure clientNonEmployeAssure) {
		    ClientEmployeNonAssure client;
			client=getClientByid(clientNonEmployeAssure.getIdClient());
			BeanUtils.copyProperties(clientNonEmployeAssure, client);
			repository.saveAndFlush(client);
	}

	@Override
	public List<Produit> ListProduitByidClient(Long idClient) {
	   return ProdRepository.ProduitByClientAssure(idClient);
	}

	@Override
	public ClientEmployeNonAssure getClientByid(Long identifiant) {
		
		ClientEmployeNonAssure clientEmpNonAss=new ClientEmployeNonAssure();
		ClientEmployeNonAssure client=null;
		Optional<ClientEmployeNonAssure>OptionalClient=repository.findById(identifiant);
	
			if(OptionalClient.isPresent()) {
				client=OptionalClient.get();
				BeanUtils.copyProperties(client, clientEmpNonAss);
				return clientEmpNonAss;
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
	public void deleteAllProdByClientEmployeNonAssure(Long idClient) {
		
		List<Produit>Product=ListProduitByidClient(idClient);
		for(int i=0; i<Product.size(); i++){
			serviceProduit.supprimerProduit(Product.get(i).getIdProduit());
		}
		SupprimerClientEmployeNonAssure(idClient);
		
	}

}
