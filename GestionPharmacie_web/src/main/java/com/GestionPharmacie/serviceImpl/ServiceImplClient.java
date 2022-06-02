package com.GestionPharmacie.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionPharmacie.domaine.Client;
import com.GestionPharmacie.domaine.ClientAssure;
import com.GestionPharmacie.repository.ClientRepository;
import com.GestionPharmacie.service.IServiceClient;
import com.GestionPharmacie.service.IServiceClientAssure;

@Service
public class ServiceImplClient implements IServiceClient {

	@Autowired
	private ClientRepository repository;
	@Autowired
	private IServiceClientAssure serviceCliAssu;
	
	@Override
	public List<Client>ListeClient(){
		return repository.findAll();
	}


}
