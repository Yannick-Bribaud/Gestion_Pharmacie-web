package com.GestionPharmacie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.GestionPharmacie.domaine.Produit;
import com.GestionPharmacie.service.IServiceClientNonAssure;

@SpringBootApplication
public class GestionPharmacieWebApplication implements CommandLineRunner {

	
	@Autowired
	IServiceClientNonAssure service;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionPharmacieWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
//		 Long idCl=(long)21;
//		List<Produit>Prod=new ArrayList<Produit>();
//		Prod=service.ListProduitByidClient(idCl);
//		for (Produit produit : Prod) {
//			System.out.println("-- "+produit.getNomProduit());
//		}
//		
		
	}

}
