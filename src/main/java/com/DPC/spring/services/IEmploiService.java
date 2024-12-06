package com.DPC.spring.services;


import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import com.DPC.spring.entities.Emploidetemps;

public interface IEmploiService {
	 String Creeremploi(Emploidetemps e , String libelle , String nomdepartement , String matiere , String classe ) throws NoSuchAlgorithmException, NoSuchPaddingException ;

}
