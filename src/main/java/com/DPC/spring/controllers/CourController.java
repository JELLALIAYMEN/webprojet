package com.DPC.spring.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DPC.spring.entities.Classe;
import com.DPC.spring.entities.Cours;
import com.DPC.spring.entities.Utilisateur;
import com.DPC.spring.repositories.ClasseRepository;
import com.DPC.spring.repositories.CoursRepository;
import com.DPC.spring.repositories.UtilisateurRepository;

@RestController
@RequestMapping("cours")
public class CourController {
@Autowired
CoursRepository courrrepos ;
@Autowired
UtilisateurRepository userrepos ;
@Autowired
ClasseRepository classrepos ; 
@PostMapping("/ajouterRapport")
public String ajouterfichier(@RequestPart("fichier") MultipartFile file, String nomcour, String email , String nomclasse)
		throws IOException {
Utilisateur u = this.userrepos.findByEmail(email);
Classe c = this.classrepos.findByNomclasse(nomclasse);

	
Cours cour = new Cours(null, nomcour, file.getBytes(), file.getOriginalFilename(), file.getContentType(), u, c);
courrrepos.save(cour);
//creer un date d'aujourd'hui
	return "true";
}	
// decompresser fichier pdf
public static byte[] decompressBytes(byte[] data) {
Inflater inflater = new Inflater();
inflater.setInput(data);
ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
byte[] buffer = new byte[1024];
try {
	while (!inflater.finished()) {
		int count = inflater.inflate(buffer);
		outputStream.write(buffer, 0, count);
	}
	outputStream.close();
} catch (IOException ioe) {
} catch (DataFormatException e) {
}
return outputStream.toByteArray();
}


public static byte[] compressBytes(byte[] data) {
Deflater deflater = new Deflater();
deflater.setInput(data);
deflater.finish();

ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
byte[] buffer = new byte[1024];
while (!deflater.finished()) {
	int count = deflater.deflate(buffer);
	outputStream.write(buffer, 0, count);
}
try {
	outputStream.close();
} catch (IOException e) {
}
return outputStream.toByteArray();
}



}
