package com.DPC.spring.services;

import java.util.List;

import com.DPC.spring.entities.Reclamation;

public interface IReclamationService {
	String reclamer(Reclamation r ,String email);
	 List<Reclamation>all();
	 Reclamation reclamatioyid(Long id);
	 List<Reclamation> recbyemail(String email );
	 String reponse(Long id, String reponse) ; 
	 String supprimer(Long id);
}
