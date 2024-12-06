package com.DPC.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Reservationmenu;
import com.DPC.spring.entities.Utilisateur;

public interface ReservationMenuRepository extends JpaRepository<Reservationmenu, Long> {

	List<Reservationmenu> findByEleve(Utilisateur u);

}
