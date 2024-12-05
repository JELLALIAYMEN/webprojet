package com.DPC.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Calendrierexamen;
import com.DPC.spring.entities.Classe;
import com.DPC.spring.entities.Salle;
import com.DPC.spring.entities.Utilisateur;

public interface CalendrierExamenReposository extends JpaRepository<Calendrierexamen, Long> {

	Calendrierexamen findByClasseAndNomjourAndPeriode(Classe c, String nomjour, String periode);

	Calendrierexamen findByUserAndNomjourAndPeriode(Utilisateur p, String nomjour, String periode);

	Calendrierexamen findBySalleAndNomjourAndPeriode(Salle s, String nomjour, String periode);

}
