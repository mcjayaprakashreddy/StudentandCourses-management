package org.jsp.springbootemailservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender mailSender;//Interface
	
	public void sendEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("kiranpatnana1@gmail.com");
        message.setSubject("Confiramation Regarding SignUp");
        message.setText("Account created Successfully");

        mailSender.send(message);
    }
	
	public void sendEmailForLogin(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("kiranpatnana1@gmail.com");
        message.setSubject("Loging Information");
        message.setText("Account loggedIn Successfully");

        mailSender.send(message);
    }

}
