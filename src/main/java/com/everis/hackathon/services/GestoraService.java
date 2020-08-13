package com.everis.hackathon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.hackathon.models.Gestora;
import com.everis.hackathon.repository.GestoraRepository;

@Service
public class GestoraService {

	private GestoraRepository repository;

	@Autowired
	public void GestoraRepository(GestoraRepository repository) {
		this.repository = repository;
	}

	public List<Gestora> findAll(){
		return this.repository.findAll();
	}
	
	public Gestora findByName(String name) {
		Gestora requested = repository.findByName(name);
		return requested;
	}
	
	public Gestora create(Gestora gestora) throws Exception {
		boolean alreadyExists = this.verifyIfExists(gestora.getName());
		
		if (alreadyExists) {
			throw new Exception("Already exists");
		}
		return this.repository.create(gestora);
	}
	
	public void deleteAll() {
		this.repository.deleteAll();
	}
	

	public boolean verifyIfExists(String name) {
		Gestora requested = repository.findByName(name);

		if (requested == null) {
			return false;
		}
		return true;
	}
}
