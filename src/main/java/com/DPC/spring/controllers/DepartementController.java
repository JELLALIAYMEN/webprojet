package com.DPC.spring.controllers;

import com.DPC.spring.services.Iproservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.DPC.spring.entities.Departement;
import com.DPC.spring.services.IDepartementService;

@RestController
@RequestMapping("departement")
public class DepartementController {
	@Autowired
	IDepartementService depservice;

	@Autowired
	Iproservice iproservice;

	@PostMapping("ajout")
	public String Ajout(@RequestBody Departement d) {
		return this.depservice.Ajout(d);

	}



}
