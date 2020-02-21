package com.assignment.twofactor.resource;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	private static final String username="subhajitbumba697@gmail.com";
	private static final String password = "jjxkbyvwebqwhtdb";
	public boolean sendEmail(String email, String twofaCode) throws AddressException, MessagingException {
		Properties props =  new Properties();
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");
		
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		message.setSubject("My two factor authentication");
		message.setText("Your two factor authentication code is:"+twofaCode);
		
		Transport.send(message);
		return true;
	}
}
