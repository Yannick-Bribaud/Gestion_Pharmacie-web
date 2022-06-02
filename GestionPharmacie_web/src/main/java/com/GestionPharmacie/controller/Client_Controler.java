package com.GestionPharmacie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.GestionPharmacie.domaine.ClientAssure;
import com.GestionPharmacie.domaine.ClientEmployeAssure;
import com.GestionPharmacie.domaine.ClientEmployeNonAssure;
import com.GestionPharmacie.domaine.ClientNonAssure;
import com.GestionPharmacie.service.IServiceClientAssure;
import com.GestionPharmacie.service.IServiceClientEmployeAssure;
import com.GestionPharmacie.service.IServiceClientEmployeNonAssure;
import com.GestionPharmacie.service.IServiceClientNonAssure;

@Controller
public class Client_Controler {
	
	@Autowired
	private IServiceClientAssure ClientAssureservice;
	@Autowired
	private IServiceClientNonAssure ClientNonAssureservice;
	@Autowired
	private IServiceClientEmployeAssure ClientEmployeAssureService;
	@Autowired
	private IServiceClientEmployeNonAssure ClientEmployeNonAssureService;
	
	
	@RequestMapping("/AjoutClientAssure")
	public String PageAjoutClientAssure(Model model) {
		ClientAssure clientAssure = new ClientAssure();
		model.addAttribute("clientAssure",clientAssure);
		return "AjoutClientAssure";
	}
	
	@RequestMapping(value = "/AjouterClientAssure", method = RequestMethod.POST)
	public String AjoutClientAssure(@ModelAttribute("clientAssure") ClientAssure clientAssure ) {
		ClientAssureservice.CreeClientAssure(clientAssure);
		return "redirect:/index";
		
	}
	
	@RequestMapping("/AjoutClientNonAssure")
	public String PageAjoutClientNonAssure(Model model) {
		ClientNonAssure clientNonAssure = new ClientNonAssure();
		model.addAttribute("clientNonAssure",clientNonAssure);
		return "AjoutClientNonAssure";
	}
	
	@RequestMapping(value = "/AjouterClientNonAssure", method = RequestMethod.POST)
	public String AjoutClientNonAssure(@ModelAttribute("clientNonAssure") ClientNonAssure clientNonAssure) {
		ClientNonAssureservice.CreeClientNonAssure(clientNonAssure);
		return "redirect:/index";
		
	}
	
	@RequestMapping("/AjoutClientEmployeAssure")
	public String PageAjoutClientEmployeAssure(Model model) {
		 ClientEmployeAssure clientEmployeAssure = new ClientEmployeAssure();
		 model.addAttribute("clientEmployeAssure",clientEmployeAssure);
		return "AjouterClientEmployeAssure";
	}
	
	
	@RequestMapping(value = "/AjouterClientEmployeAssure", method = RequestMethod.POST)
	public String AjoutClientEmployeAssure(@ModelAttribute("clientEmployeAssure") ClientEmployeAssure clientEmployeAssure){
		ClientEmployeAssureService.CreeClientEmployeAssure(clientEmployeAssure);
		return "redirect:/index";
	}
	
	@RequestMapping("/AjoutClientEmployeNonAssure")
	public String PageAjoutClientEmployeNonAssure(Model model) {
		ClientEmployeNonAssure clientEmployeNonAssure = new ClientEmployeNonAssure();
		 model.addAttribute("clientEmployeNonAssure",clientEmployeNonAssure);
		return "AjouterClientEmployeNonAssure";
	}
	
	@RequestMapping(value = "/AjouterClientEmployeNonAssure", method = RequestMethod.POST)
	public String AjoutClientEmployeNonAssure(@ModelAttribute("clientEmployeNonAssure") ClientEmployeNonAssure clientEmployeNonAssure){
		ClientEmployeNonAssureService.CreeClientEmployeNonAssure(clientEmployeNonAssure);
		return "redirect:/index";
	}
	
	
	@RequestMapping("/Modifier/{idClient}")
	public ModelAndView ModifierClientAssure(@PathVariable(name="idClient")Long idClient) {
			ModelAndView mav = new ModelAndView("Modifier_ClientAssure");
			ClientAssure clientAssure = ClientAssureservice.getClientByid(idClient);
			mav.addObject("clientAssure",clientAssure);
		return mav;
	}
	
	@RequestMapping("/ModifierEmployeAssure/{idClient}")
	public ModelAndView ModifierClientEmployeAssure(@PathVariable(name="idClient") Long idClient) {
			ModelAndView mav = new ModelAndView("Modifier_ClientEmployeAssure");
			ClientEmployeAssure clientEmployeAssure = ClientEmployeAssureService.getClientByid(idClient);
			mav.addObject("clientEmployeAssure",clientEmployeAssure);
		return mav;
	}
	
	@RequestMapping("/ModifierEmployeNonAssure/{idClient}")
	public ModelAndView ModifierClientEmployeNonAssure(@PathVariable(name="idClient") Long idClient) {
		   ModelAndView mav = new ModelAndView("Modifier_ClientEmployeNonAssure");
		   ClientEmployeNonAssure clientEmployeNonAssure = ClientEmployeNonAssureService.getClientByid(idClient);
		   mav.addObject("clientEmployeNonAssure",clientEmployeNonAssure);
		return mav;
	}
	
	@RequestMapping("/ModifierClientNonAssure/{idClient}")
	public ModelAndView ModifierClientNonAssure(@PathVariable(name="idClient") Long idClient) {
		   ModelAndView mav = new ModelAndView("Modifier_ClientNonAssure");
		   ClientNonAssure clientNonAssure = ClientNonAssureservice.getClientByid(idClient);
		   mav.addObject("clientNonAssure",clientNonAssure);
		return mav;
	}
	
	@RequestMapping("/SupprimerClient&Produit/{idClient}")
	public String SupprimerClientAssure(@PathVariable(name="idClient") Long idClient) {
		ClientAssureservice.deleteAllProdByClientAssure(idClient); 
		return "redirect:/ListClientAssure";
	}
	
	@RequestMapping("/SupprimerClientEmplAss&Produit/{idClient}")
	public String SupprimerClientEmployeAssure(@PathVariable(name="idClient") Long idClient) {
		ClientEmployeAssureService.deleteAllProdByClientEmployeAssure(idClient);
		return "redirect:/ListClientEmployeAssure";
	}
	
	@RequestMapping("/SupprimerClientEmplNonAss&Produit/{idClient}")
	public String SupprimerClientEmployeNonAssure(@PathVariable(name="idClient") Long idClient) {
		ClientEmployeNonAssureService.deleteAllProdByClientEmployeNonAssure(idClient);
		return "redirect:/ListClientEmployeNonAssure";
	}
	
	@RequestMapping("/SupprimerClientNonAss&Produit/{idClient}")
	public String SupprimerClientNonAssure(@PathVariable(name="idClient") Long idClient) {
		ClientNonAssureservice.deleteAllProdByClientNonAssure(idClient);
		return "redirect:/ListClientNonAssure";
	}
		

}
