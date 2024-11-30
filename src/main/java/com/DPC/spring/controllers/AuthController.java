package com.DPC.spring.controllers;

import com.DPC.spring.entities.LoginRequest;
import com.DPC.spring.entities.LoginResponse;
import com.DPC.spring.entities.Utilisateur;

import com.DPC.spring.repositories.UtilisateurRepository;
import com.DPC.spring.security.jwt.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("auth")
public class AuthController {

   
    @Autowired
    UtilisateurRepository userrepos ;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtils jwtTokenUtils;
    @PostMapping("/login2")
    public ResponseEntity<LoginResponse> login2(@Valid @RequestBody LoginRequest loginRequest)
    {
	
    	
    	  Authentication authentication = authenticationManager.authenticate(
                  new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

          SecurityContextHolder.getContext().setAuthentication(authentication);
          UserDetails userDetails = (UserDetails) authentication.getPrincipal();
          String token = this.jwtTokenUtils.generateToken(userDetails);
    	
		Utilisateur contact = this.userrepos.findByEmail(loginRequest.getEmail());
		System.out.println(contact);
		return ResponseEntity.ok(new LoginResponse(token, "Bearer", "Login successfully",contact.getAuthorities().getName(),loginRequest.getEmail()));
  }
    
}
