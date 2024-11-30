package com.DPC.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DPC.spring.entities.Salle;
import com.DPC.spring.repositories.SalleRepository;

@RestController
@RequestMapping("salle")
public class SalleController {

@Autowired
SalleRepository sallerepos ; 

@PostMapping("/ajout")
public String Ajout(@RequestBody Salle s) {
	
	Salle sexiste = this.sallerepos.findByNomdesalle(s.getNomdesalle());
	if(sexiste==null) {
		this.sallerepos.save(s);
		return "true";
	}
	else {
		return "false";
	}
} 
@GetMapping("/affichage")
public List<Salle> affich(){
	return this.sallerepos.findAll();
}

@PutMapping("/modif")
public String modif(Long id , String nom) {
	Salle s = this.sallerepos.findById(id).get();
	s.setNomdesalle(nom);
	this.sallerepos.saveAndFlush(s);
	return "true";
	
}


}
