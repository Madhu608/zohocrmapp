package com.zohocrmapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailserviceImpl implements Emailservice {

	  @Autowired 
	  private JavaMailSender javaMailSender;
	
	@Override
	public void SendEmail(String to, String sub, String msg) {
		SimpleMailMessage mailMessage= new SimpleMailMessage();
			mailMessage.setTo(to);
			mailMessage.setSubject(sub);
			mailMessage.setText(msg);
			
			javaMailSender.send(mailMessage);
	}

}
