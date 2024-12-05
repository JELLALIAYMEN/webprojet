package com.DPC.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DPC.spring.entities.Calendrierexamen;
import com.DPC.spring.services.ICalendrierExamenService;

@RestController
@RequestMapping("calendrier")
public class CalendrierExamenConrtroller {
@Autowired
ICalendrierExamenService service ; 
@PostMapping("/creer")
public String Creercalendrier(@RequestBody Calendrierexamen calendrier , String libelle , String salles , String matiere , String classe, String typecalendrier ) {
	return this.service.Creercalendrier(calendrier, libelle, salles, matiere, classe,typecalendrier);
}

	
}
