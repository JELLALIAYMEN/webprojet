package com.DPC.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DPC.spring.entities.Matiere;
import com.DPC.spring.repositories.MatiereRepository;

@RestController
@RequestMapping("matiere")
public class Matierecontroller {
@Autowired
MatiereRepository matrepos ; 

}

