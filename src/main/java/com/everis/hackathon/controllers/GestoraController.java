package com.everis.hackathon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.everis.hackathon.models.Gestora;
import com.everis.hackathon.services.GestoraService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Hackathon Rest API", tags = {"Gestora"})
@RestController
@RequestMapping(value="/api/v1/gestoras", produces = MediaType.APPLICATION_JSON_VALUE)
public class GestoraController {

	private GestoraService service;

	@Autowired
	private GestoraController(GestoraService service) {
		this.service = service;
	}

	
	@ApiOperation(value = "Retorna uma lista de Gestoras")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Gestora>> list() {
		List<Gestora> gestoras = this.service.findAll();

		if(gestoras.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(gestoras);
	}
	
	
	@ApiOperation(value="Retorna uma gestora de acordo com parâmetro")
	@RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
	public ResponseEntity<Gestora> findOne(@PathVariable String name) {
		return ResponseEntity.ok(this.service.findByName(name));
	}
	

	@ApiOperation(value="Cria uma Gestora")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Gestora> create(@RequestBody Gestora gestora) throws Exception {
		Gestora created = this.service.create(gestora);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@ApiOperation(value="Deleta todas as gestoras")
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteAll() {
		this.service.deleteAll();
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
}
