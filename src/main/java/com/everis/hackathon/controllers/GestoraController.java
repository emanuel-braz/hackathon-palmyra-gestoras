package com.everis.hackathon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.hackathon.models.Gestora;
import com.everis.hackathon.services.GestoraService;

@RestController
@RequestMapping(value="/api/v1/gestoras", produces = MediaType.APPLICATION_JSON_VALUE)
public class GestoraController {

	private GestoraService service;

	@Autowired
	private GestoraController(GestoraService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Gestora>> list() {
		List<Gestora> gestoras = this.service.findAll();

		if(gestoras.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(gestoras);
	}

	@PostMapping
	public ResponseEntity<Gestora> create(@RequestBody Gestora gestora) {
		Gestora created = this.service.create(gestora);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
}
