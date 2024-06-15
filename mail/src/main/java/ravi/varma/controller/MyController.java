package ravi.varma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired
	JavaMailSender sender;
	
	@GetMapping("/mail")
	public String mail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("techiegaru@gmail.com");
		msg.setFrom("techiegaru@gmail.com");
		msg.setText("Test Message");
		msg.setSubject("Test Message");
		sender.send(msg);
		
		return "Mail Sent";
	}

}
