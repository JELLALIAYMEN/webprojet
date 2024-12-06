package com.DPC.spring.services;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import com.DPC.spring.entities.Calendrierexamen;

public interface ICalendrierExamenService {
	public String Creercalendrier(Calendrierexamen calendrier , String libelle , String salles , String matiere , String classe, String typecalendrier )throws NoSuchAlgorithmException, NoSuchPaddingException;

}
