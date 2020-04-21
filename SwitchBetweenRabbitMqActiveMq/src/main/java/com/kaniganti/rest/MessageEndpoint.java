package com.kaniganti.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaniganti.rabbitmq.RabbitSender;
@RestController
public class MessageEndpoint {
	
	@Autowired
	RabbitSender sender;
	@RequestMapping("/send/{message}")
	public String sendMessage(@PathVariable String message) {		
	    sender.sendMessage(message);
		return "Message sent";
	}

		
		

}
