package com.DPC.spring.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.DPC.spring.entities.Classe;
import com.DPC.spring.entities.Departement;
import com.DPC.spring.entities.Emploidetemps;
import com.DPC.spring.entities.Matiere;
import com.DPC.spring.entities.Nondisponible;
import com.DPC.spring.entities.Professeur;
import com.DPC.spring.entities.Salle;
import com.DPC.spring.repositories.ClasseRepository;
import com.DPC.spring.repositories.DepartementRepository;
import com.DPC.spring.repositories.EmploiRepository;
import com.DPC.spring.repositories.Matiererep;
import com.DPC.spring.repositories.NomdispoRepository;
import com.DPC.spring.repositories.ProfesseurRepository;
import com.DPC.spring.repositories.SalleRepository;
import com.DPC.spring.services.IEmploiService;

@Service
public class EmploiServiceImpl implements IEmploiService {

@Autowired
EmploiRepository emploirepos ; 
@Autowired
ProfesseurRepository profrespo ; 
@Autowired
DepartementRepository deparrepos ; 
@Autowired
Matiererep matrepos ; 
@Autowired
ClasseRepository classeRepos ; 
@Autowired
NomdispoRepository nondispo ; 
@Autowired
SalleRepository sallerepos ; 

public String Creeremploi(Emploidetemps e , String libelle , String salles , String matiere , String classe ) {
	Professeur p = this.profrespo.findByLibelle(libelle);
	Salle s = this.sallerepos.findByNomdesalle(salles);
	System.out.println(salles);
	Matiere m = this.matrepos.findByNom(matiere);
	Classe c = this.classeRepos.findByNomclasse(classe);
	
	
	Nondisponible existe = this.nondispo.findByNomjourAndProf(e.getNomjour(),p);
	if(existe!=null) {
		return "prof n'est pas disponible";
	}
	else
	{
		Emploidetemps emploiprofclasse = this.emploirepos.findByProfAndClasseAndNomjour(p,c,e.getNomjour());	
		if(emploiprofclasse!=null) {
			return "prof a ensiegne pour cette classe aujourd'hui";
		}
		else {
			Emploidetemps emploiclasse = this.emploirepos.findByClasseAndNomjourAndHeure(c,e.getNomjour(),e.getHeure());
			if(emploiclasse!=null) {
				return "ce classe n'est pas disponible dans cette heure";
			}
			else {
				Emploidetemps esalle = this.emploirepos.findBySalleAndNomjourAndHeure(s,e.getNomjour(),e.getHeure());
				if(esalle!=null) {
					return "salle n'est pas dispo";
				}
				else {
					e.setClasse(c);
					e.setMatiere(m);
					e.setSalle(s);
					e.setProf(p);
					this.emploirepos.save(e);
					return  "true"; 
				}
			}
			
			
		}

		
	
		
	}
	

	
	
		
	
	
}

	
}
