package com.everis.hackathon.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.everis.hackathon.models.Gestora;

@Repository
public class GestoraRepository {

	private Map<String, Gestora> repository = new HashMap<>();

	public List<Gestora> findAll() {
		return new ArrayList<>(this.repository.values());
	}

	public Gestora findByName(String name) {
		return this.repository.get(name);
	}

	public Gestora create(Gestora gestora) {
		this.repository.put(gestora.getName(), gestora);
		return gestora;
	}

	public void delete(String name) {
		this.repository.remove(name);
	}
	
	public void deleteAll() {
		this.repository.clear();
	}
}
