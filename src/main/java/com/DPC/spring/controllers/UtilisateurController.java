package com.DPC.spring.controllers;

import com.DPC.spring.services.IUtilisateurService;
import com.DPC.spring.services.MailService;

import com.DPC.spring.services.UtilisateurServiceImp;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.DPC.spring.entities.Autority;
import com.DPC.spring.entities.Classe;
import com.DPC.spring.entities.Utilisateur;
import com.DPC.spring.repositories.AuthorityRepository;
import com.DPC.spring.repositories.ClasseRepository;
import com.DPC.spring.repositories.UtilisateurRepository;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.crypto.NoSuchPaddingException;
import javax.persistence.EntityNotFoundException;


@CrossOrigin("*")
@RestController
@RequestMapping("users")
public class UtilisateurController {

	// crud  Utilisateur

	@Autowired
	IUtilisateurService UtilisateurServiceImp;


	//security login hhhh
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	UtilisateurRepository userrepos;
	@Autowired
	AuthorityRepository authrepos;
	@Autowired
	MailService mailservice;


	@Autowired
	ClasseRepository classerepos;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String Ajout(@RequestBody Utilisateur user, String nomclasse) {
		Utilisateur userexist = this.userrepos.findByEmail(user.getEmail());
		if (userexist == null) {
			Classe c = this.classerepos.findByNomclasse(nomclasse);
			Autority auth = this.authrepos.findByName(user.getProfil());
			String pass = encoder.encode(user.getPassword());
			user.setAuthorities(auth);
			user.setPassword(pass);
			user.setDatecreation(new Date(System.currentTimeMillis()));
			user.setArchiver(false);
			user.setClasse(c);
			this.userrepos.save(user);
			return "true";
		} else {
			return "user exist";
		}
	}


	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value = "/admintest", method = RequestMethod.GET)
	public String testconnectadmin() {
		return "profil admin";
	}

	@RequestMapping(value = "/archiver", method = RequestMethod.POST)
	public String archiver(Long id) {
		Utilisateur u = this.userrepos.findById(id).get();
		u.setArchiver(true);
		this.userrepos.saveAndFlush(u);
		return "true";
	}

	@GetMapping("/getbyid")
	public Utilisateur getbyid(Long id) {
		Utilisateur u = this.userrepos.findById(id).get();
		return u;
	}

	//		@GetMapping("/getbyemail")
//		public Utilisateur userbyemail(String email) {
//			Utilisateur u = this.userrepos.findByEmail(email);
//			return u ;
//}
	@PostMapping("/changemp")
	public Utilisateur changemp(Long id, String password) {
		Utilisateur u = this.userrepos.findById(id).get();
		String pass = encoder.encode(password);
		u.setPassword(pass);
		this.userrepos.saveAndFlush(u);
		return u;
	}

	@GetMapping("/countuser")
	public Long countuser() {
		return this.userrepos.countuser();
	}

	@GetMapping("/countmembre")
	public Long countmembre() {
		return this.userrepos.countmembre();
	}

	@GetMapping("/countjoueur")
	public Long countjoueur() {
		return this.userrepos.countjoueur();
	}

	@GetMapping("/countdoc")
	public Long countdoc() {
		return this.userrepos.countdocument();
	}

	@GetMapping("/par-profil")
	public List<Utilisateur> findAllByProfil(@RequestParam String profil) {
		// Appeler le service pour récupérer tous les utilisateurs avec le profil donné
		return UtilisateurServiceImp.findAllByProfil(profil);
	}


	@PostMapping("/affecter/{email}/{id}")
	public Utilisateur affecterUtilisateurClasse(@PathVariable String email, @PathVariable Long id) {
		// Appel de la méthode pour affecter l'utilisateur
		Utilisateur utilisateur = UtilisateurServiceImp.affecterUtilisateurClasse(email, id);

		if (utilisateur != null) {
			// Si l'utilisateur a été affecté avec succès, le renvoyer
			return utilisateur;
		} else {
			// Si l'utilisateur n'a pas été trouvé ou affecté, renvoyer null ou une autre valeur
			return null;
		}
	}
	@PostMapping("/affecter-departement")
	public List<Utilisateur> affecterUtilisateurDepartement(@RequestParam Long id, @RequestParam String email) {
		// Appeler la méthode du service pour affecter l'utilisateur au département
		return UtilisateurServiceImp.affecterUtilisateurDepartement(id, email);
	}
}


