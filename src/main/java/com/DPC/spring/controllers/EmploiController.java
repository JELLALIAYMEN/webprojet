package com.DPC.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DPC.spring.entities.Emploidetemps;
import com.DPC.spring.serviceImpl.EmploiServiceImpl;

@RestController
@RequestMapping("emploi")
public class EmploiController {
	@Autowired
	EmploiServiceImpl emploiservice ; 
	
	
	
	@PostMapping("/creeremploi")
	public String Creeremploi(@RequestBody Emploidetemps e , String libelle , String salle , String matiere , String classe ) {
		System.out.println(salle);
		return this.emploiservice.Creeremploi(e, libelle, salle, matiere, classe); 
	}

}
