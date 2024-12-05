package com.DPC.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DPC.spring.entities.Departement;
import com.DPC.spring.repositories.DepartementRepository;
import com.DPC.spring.services.IDepartementService;

@RestController
@RequestMapping("departement")
public class DepartementController {
@Autowired
IDepartementService depservice ; 


@PostMapping("ajout")
public String Ajout(@RequestBody Departement d ) {
	return this.depservice.Ajout(d);
	
}

}
