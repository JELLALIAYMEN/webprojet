package com.DPC.spring.services;


import javax.mail.internet.MimeMessage;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.NoSuchPaddingException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.DPC.spring.entities.PasswordResetToken;
import com.DPC.spring.entities.Utilisateur;
import com.DPC.spring.repositories.UtilisateurRepository;

/**
 * @author USER
 *
 */

@Service
public class MailService {
	@Autowired
	JavaMailSender mailSender;
		@Autowired
	private PasswordEncoder encoder;
	
	@Autowired 
	JavaMailSender javaMailSender;
	String emailClient="tataouine@gmail.com";
	public void sendMailWithAttachment(String toEmail,
			                           String body,
			                           String subject,
			                           String attchment) throws MessagingException {
		
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
		mimeMessageHelper.setFrom(emailClient);
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystemResource= new FileSystemResource(new File(attchment));
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		javaMailSender.send(mimeMessage);
		System.out.println("Mail with attachment sent successfully.");
		

	}
	
	
		
@Autowired
UtilisateurRepository userrepos ;
	public Map<String, Boolean> RenisialiserMotdepasse(String emailcrypter)
	throws NoSuchAlgorithmException, NoSuchPaddingException {
	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	Map<String, Boolean> success = new TreeMap<String, Boolean>();
	List<PasswordResetToken> listpasswordResetToken = new ArrayList<>();
	try {
	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	org.springframework.security.crypto.password.PasswordEncoder passwordEncorder = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();



	   Utilisateur u = this.userrepos.findByEmail(emailcrypter);
	String email = encoder.encode(emailcrypter);
	String emails= email.replaceAll("/","-");

	//String email = passwordEncorder.encode(emailcrypter);
	PasswordResetToken tosave = new PasswordResetToken();
	success.put("response", true);

	mimeMessageHelper.setSubject("test mail");
	mimeMessageHelper.setFrom(email);
	mimeMessageHelper.setTo(emailcrypter);
	String content =" Bonjour Mr (Mme), <br>"

					+ "Cordialement ,<br><br>" ;
	mimeMessageHelper.setText(content);
	// Add a resource as an attachment
	mimeMessageHelper.setText("<html><body><p>" + content
	+ "</p> </body></html>",
	true);
	javaMailSender.send(mimeMessageHelper.getMimeMessage());



	success.put("response", false);
	} catch (MessagingException x) {
	x.printStackTrace();
	}
	return success;

	}



	
	
	public Map<String, Boolean> EnvoyerEmploi(String emailcrypter, Date date , String heure , String jour , String matiere , String salle , String prof )
	throws NoSuchAlgorithmException, NoSuchPaddingException {
	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	Map<String, Boolean> success = new TreeMap<String, Boolean>();
	List<PasswordResetToken> listpasswordResetToken = new ArrayList<>();
	try {
	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	org.springframework.security.crypto.password.PasswordEncoder passwordEncorder = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
	Utilisateur u = this.userrepos.findByEmail(emailcrypter);
	String email = encoder.encode(emailcrypter);
	String emails= email.replaceAll("/","-");
	PasswordResetToken tosave = new PasswordResetToken();
	success.put("response", true);

	mimeMessageHelper.setSubject("Emploi du temps");
	mimeMessageHelper.setFrom(email);
	mimeMessageHelper.setTo(emailcrypter);
	String content =" Bonjour Mr (Mme), "+u.getNom()+" "+u.getPrenom()+ " Voila la nouvelle emploie <br>"
			+ "Date : "+date+" ,<br><br>"
			+ "heure :"+heure+" ,<br><br>"
			+ "Jour:"+jour+",<br><br>"
			+ "Matiere :"+matiere+" ,<br><br>"
			+ "Salle:"+salle+",<br><br>"
			+"Prof:"+prof+",<br><br>"
			
					+ "Cordialement ,<br><br>" ;
	mimeMessageHelper.setText(content);
	// Add a resource as an attachment
	mimeMessageHelper.setText("<html><body><p>" + content
	+ "</p> </body></html>",
	true);
	javaMailSender.send(mimeMessageHelper.getMimeMessage());



	success.put("response", false);
	} catch (MessagingException x) {
	x.printStackTrace();
	}
	return success;

	}


	public Map<String, Boolean> calendrierExamen(String emailcrypter, Date date , String heure , String jour , String matiere , String salle , String prof,String type  )
			throws NoSuchAlgorithmException, NoSuchPaddingException {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			Map<String, Boolean> success = new TreeMap<String, Boolean>();
			List<PasswordResetToken> listpasswordResetToken = new ArrayList<>();
			try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			org.springframework.security.crypto.password.PasswordEncoder passwordEncorder = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
			Utilisateur u = this.userrepos.findByEmail(emailcrypter);
			String email = encoder.encode(emailcrypter);
			String emails= email.replaceAll("/","-");
			PasswordResetToken tosave = new PasswordResetToken();
			success.put("response", true);

			mimeMessageHelper.setSubject("Calendrier Examen");
			mimeMessageHelper.setFrom(email);
			mimeMessageHelper.setTo(emailcrypter);
			String content =" Bonjour Mr (Mme), "+u.getNom()+" "+u.getPrenom()+ " Voila la nouvelle emploie <br>"
					+ "Date : "+date+" ,<br><br>"
					+ "heure :"+heure+" ,<br><br>"
					+ "Jour:"+jour+",<br><br>"
					+ "Matiere :"+matiere+" ,<br><br>"
					+ "Salle:"+salle+",<br><br>"
					+"Prof:"+prof+",<br><br>"
					+"Type Calendrier:"+type+",<br><br>"
					
							+ "Cordialement ,<br><br>" ;
			mimeMessageHelper.setText(content);
			// Add a resource as an attachment
			mimeMessageHelper.setText("<html><body><p>" + content
			+ "</p> </body></html>",
			true);
			javaMailSender.send(mimeMessageHelper.getMimeMessage());



			success.put("response", false);
			} catch (MessagingException x) {
			x.printStackTrace();
			}
			return success;

			}


	
	
}
