package com.GestionPharmacie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.GestionPharmacie.domaine.Client;
import com.GestionPharmacie.domaine.ClientNonAssure;
import com.GestionPharmacie.domaine.Medicament;
import com.GestionPharmacie.domaine.Parapharmacie;
import com.GestionPharmacie.domaine.Produit;
import com.GestionPharmacie.repository.MedicamentRepository;
import com.GestionPharmacie.service.IServiceClient;
import com.GestionPharmacie.service.IServiceClientAssure;
import com.GestionPharmacie.service.IServiceProduit;

@Controller
public class Produit_Controler {
	
	@Autowired
	private IServiceProduit Service;
	@Autowired
	private IServiceClient serviceClient;
	
	
	
	
	@RequestMapping("/AjoutProduitParapharmacie")
	public String PageAjoutParapharmacie(Model model) {
		Parapharmacie parapharmacie = new Parapharmacie();
		List<Client>listClient=serviceClient.ListeClient();
		model.addAttribute("listClient",listClient);
		model.addAttribute("parapharmacie",parapharmacie);
		return "AjoutProduitParapharmacie";	
	}
	
	@RequestMapping(value = "/AjoutProduitParapharmaceutique", method = RequestMethod.POST)
	public String AjoutParapharmacie(@ModelAttribute("parapharmacie") Parapharmacie parapharmacie) {
		Service.AddProduit(parapharmacie);
		return "redirect:/ListProduitParapharmacie";	
	}
	
	
	@RequestMapping("/AjoutProduitMedicament")
	public String PageAjoutMedicament(Model model) {
		Medicament medicament = new Medicament();
		List<Client>listClient=serviceClient.ListeClient();
		model.addAttribute("medicament",medicament);
		model.addAttribute("listClient",listClient);
		return "AjoutProduitMedicament";	
	}
	
	@RequestMapping(value = "/AjoutProduitMedicament", method = RequestMethod.POST)
	public String AjoutMedicament(@ModelAttribute("Medicament") Medicament medicament) {
		Service.AddProduit(medicament);
		return "redirect:/index";	
	}
	
	@RequestMapping("/ListProduitParapharmacie")
	public String PageListeParapharmacie(Model model) {
		List<Parapharmacie>listParapharmacie=Service.AllParapharmacie();
		model.addAttribute("listParapharmacie",listParapharmacie);
		
		return "ListProduitParapharmacie";	
	}
	
	
	@RequestMapping("/ListProduitMedicaments")
	public String PageListeMedicament(Model model) {
		List<Medicament>listMedicament=Service.AllMedicament();
		model.addAttribute("listMedicament",listMedicament);
		
		return "ListProduitMedicaments";	
	}
	
	@RequestMapping("/ModifierMedicament/{idProduit}")
	public ModelAndView ModifierMedicament(@PathVariable(name="idProduit") Long idProduit) {
		   ModelAndView mav = new ModelAndView("Modifier_Medicament");
		   List<Client>listClient=serviceClient.ListeClient();
		   Produit medicament = Service.getProduitById(idProduit);
		   mav.addObject("listClient",listClient);
		   mav.addObject("medicament",medicament);
		return mav;
	}
	
	@RequestMapping("/ModifierParapharmacie/{idProduit}")
	public ModelAndView ModifierParapharmacie(@PathVariable(name="idProduit") Long idProduit) {
		   ModelAndView mav = new ModelAndView("Modifier_Parapharmacie");
		   List<Client>listClient=serviceClient.ListeClient();
		   Produit parapharmacie = Service.getProduitById(idProduit);
		   mav.addObject("listClient",listClient);
		   mav.addObject("parapharmacie",parapharmacie);
		return mav;
	}
	
	
	@RequestMapping("/SupprimerParapharmacie/{idProduit}")
	public String SupprimerParapharmacie(@PathVariable(name="idProduit") Long idProduit) {
		Service.supprimerProduit(idProduit);  
		return "redirect:/ListProduitParapharmacie";
	}
	
	@RequestMapping("/SupprimerMedicament/{idProduit}")
	public String SupprimerMedicament(@PathVariable(name="idProduit") Long idProduit) {
		Service.supprimerProduit(idProduit);  
		return "redirect:/ListProduitMedicaments";
	}
	
}
