package com.DPC.spring.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Classe;
import com.DPC.spring.entities.Emploidetemps;
import com.DPC.spring.entities.Professeur;
import com.DPC.spring.entities.Salle;

public interface EmploiRepository extends JpaRepository<Emploidetemps, Long> {

	Emploidetemps findByProfAndClasseAndDate(Professeur p, Classe c, Date date);

	Emploidetemps findByClasseAndDateAndHeure(Classe c, Date date, String heure);

	Emploidetemps findByProfAndClasseAndHeureAndNomjour(Professeur p, Classe c, String heure, String nomjour);

	Emploidetemps findByProfAndClasseAndNomjour(Professeur p, Classe c, String nomjour);

	Emploidetemps findByClasseAndNomjourAndHeure(Classe c, String nomjour, String heure);

	Emploidetemps findBySalleAndNomjourAndHeure(Salle s, String nomjour, String heure);

}
