package com.GestionPharmacie.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.GestionPharmacie.domaine.Client;
import com.GestionPharmacie.domaine.ClientAssure;
import com.GestionPharmacie.domaine.ClientEmployeAssure;
import com.GestionPharmacie.domaine.ClientEmployeNonAssure;
import com.GestionPharmacie.domaine.ClientNonAssure;
import com.GestionPharmacie.domaine.Produit;
import com.GestionPharmacie.service.IServiceClient;
import com.GestionPharmacie.service.IServiceClientAssure;
import com.GestionPharmacie.service.IServiceClientEmployeAssure;
import com.GestionPharmacie.service.IServiceClientEmployeNonAssure;
import com.GestionPharmacie.service.IServiceClientNonAssure;
import com.GestionPharmacie.service.IServiceProduit;



@Controller
public class index_Controler {
	
	@Autowired
	private IServiceClient  service;
	@Autowired
	private IServiceClientAssure ClientAssureservice;
	@Autowired
	private IServiceClientNonAssure ClientNonAssureservice;
	@Autowired
	private IServiceClientEmployeAssure ClientEmployeAssureservice;
	@Autowired
	private IServiceClientEmployeNonAssure ClientEmployeNonAssureservice;
	@Autowired
	private IServiceProduit ProdService;
	
	
	@RequestMapping("/index")
	public String acceuil(Model model) {
		List<Client>listClient=service.ListeClient();
		model.addAttribute("listClient",listClient);
		return "index";
	}
	
	@RequestMapping("/ListClientAssure")
	public String clientAssure(Model model) {
		List<ClientAssure>listClientAssure=ClientAssureservice.ListClientAssure();
		model.addAttribute("listClientAsure",listClientAssure);
		return "ListClientAssure";
	}
	
	
	@RequestMapping("/ListClientNonAssure")
	public String ClientNonAssure(Model model) {
		List<ClientNonAssure>listClientNonAssure=ClientNonAssureservice.ListClientNonAssure();
		model.addAttribute("ListClientNonAssure",listClientNonAssure);
		return"ListClientNonAssure";
	}
	
	@RequestMapping("/ListClientEmployeAssure")
	public String ClientEmployeAssure(Model model) {
		List<ClientEmployeAssure>listClientEmployeAssure=ClientEmployeAssureservice.ListClientEmployeAssure();
		model.addAttribute("listClientEmployeAssure",listClientEmployeAssure);
		return "ListClientEmployeAssure";
	}
	
	
	
	@RequestMapping("/ListClientEmployeNonAssure")
	public String ClientEmployeNonAssure(Model model) {
		List<ClientEmployeNonAssure>listClientEmployeNonAssure=ClientEmployeNonAssureservice.ListClientEmployeNonAssure();
		model.addAttribute("listClientEmployeNonAssure",listClientEmployeNonAssure);
		return "ListClientEmployeNonAssure";
	}
	
	
	@RequestMapping("/ListeTousProduits")
	public String listeProduit(Model model) {
	List<Produit>listProduit=ProdService.ListProduit();
	model.addAttribute("listProduit",listProduit);
		return "ListeTousProduits";
	}
	
	@RequestMapping("/AjoutClient")
	public String AjouterClient(Model model) {
		   return "AjoutClient";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
