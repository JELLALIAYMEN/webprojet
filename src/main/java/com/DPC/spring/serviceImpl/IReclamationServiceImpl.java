package com.DPC.spring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DPC.spring.entities.Reclamation;
import com.DPC.spring.entities.Utilisateur;
import com.DPC.spring.repositories.ReclamationRepository;
import com.DPC.spring.repositories.UtilisateurRepository;
import com.DPC.spring.services.IReclamationService;
@Service
public class IReclamationServiceImpl implements IReclamationService {
@Autowired
ReclamationRepository reclamationrepos ; 
@Autowired
UtilisateurRepository userrepos ; 

public String reclamer(Reclamation r ,String email) {
	Utilisateur u = this.userrepos.findByEmail(email);
	r.setUser(u);
	this.reclamationrepos.save(r);
	return "true" ; 
}

public List<Reclamation>all(){
	return this.reclamationrepos.findAll();
} 
public Reclamation reclamatioyid(Long id) {
	Reclamation r = this.reclamationrepos.findById(id).get();
	return r ; 
}
public List<Reclamation> recbyemail(String email ){
	Utilisateur u = this.userrepos.findByEmail(email);
	List<Reclamation> listbyuser = this.reclamationrepos.findByUser(u);
	return listbyuser ; 
	
}
public String reponse(Long id, String reponse) {
	Reclamation r = this.reclamationrepos.findById(id).get();
	r.setResultat(reponse);
	this.reclamationrepos.saveAndFlush(r);
	return "true" ;

}
} 
