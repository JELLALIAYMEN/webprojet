package com.DPC.spring.services;

import com.DPC.spring.entities.Calendrierexamen;

public interface ICalendrierExamenService {
	public String Creercalendrier(Calendrierexamen calendrier , String libelle , String salles , String matiere , String classe, String typecalendrier );

}
