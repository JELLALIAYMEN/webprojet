package com.DPC.spring.controllers;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

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
public String Creercalendrier(@RequestBody Calendrierexamen calendrier , String email , String salles , String matiere , String classe, String typecalendrier )throws NoSuchAlgorithmException, NoSuchPaddingException {
	return this.service.Creercalendrier(calendrier, email, salles, matiere, classe,typecalendrier);
}

	
}
