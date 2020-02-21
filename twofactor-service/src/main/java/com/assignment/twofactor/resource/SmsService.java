package com.assignment.twofactor.resource;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {
	private static final String account_sid = "**";
	private static final String auth_id = "**";

	static {
		Twilio.init(account_sid, auth_id);
	}
	public boolean sendTwofacode(String number, String twofaCode) {
		// second phone number is from my twilio account and its paid
		Message.creator(new PhoneNumber(number), new PhoneNumber("+16122554559"), "Hi ,this is Subhajit here,Your two factor auth code is:"+twofaCode).create();
		return true;
	}
}
