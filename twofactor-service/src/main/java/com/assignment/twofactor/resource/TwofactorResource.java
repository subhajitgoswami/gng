package com.assignment.twofactor.resource;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.twofactor.dao.TwofactorDaoService;

@RestController
public class TwofactorResource {

	@Autowired
	EmailService emailService;
	
	@Autowired
	TwofactorDaoService twofactorDaoService;
	
	@Autowired
	SmsService smsService;

	@RequestMapping(value = "/users/{userId}/emails/{emailId}/2fa", method = RequestMethod.PUT)
	public ResponseEntity<Object> sendTwofaCodeInEmail(@PathVariable("userId") String userId,
			@PathVariable("emailId") String emailId) throws AddressException, MessagingException {
		String twofaCode = String.valueOf(new Random().nextInt(9999) + 1000);
		emailService.sendEmail(emailId, twofaCode);
		twofactorDaoService.updateTwofaProperties(userId, twofaCode);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{userId}/mobilenumbers/{mobilenumber}/2fa", method = RequestMethod.PUT)
	public ResponseEntity<Object> sendTwofaCodeInSMS(@PathVariable("userId") String userId,
			@PathVariable("mobilenumber") String mobile) {
		String twofaCode = String.valueOf(new Random().nextInt(9999) + 1000);
		smsService.sendTwofacode(mobile, twofaCode);
		twofactorDaoService.updateTwofaProperties(userId, twofaCode);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<Object> recieveHi() {
		System.out.println("hi");
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
