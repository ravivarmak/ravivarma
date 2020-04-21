package com.kaniganti.rabbitmq;

import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Configuration
public class RabbitSender {
	
	@Autowired
	ProducerTemplate producerTemplate;

	@EndpointInject(uri = "rabbitmq://3.22.117.30/respExch?vhost=/&routingKey=response&username=ravi&password=ravi&queue=ResponseQueue&autoDelete=false")
	private Endpoint rabbitMQEndpoint;
public String sendMessage(Object template) {
		
		producerTemplate.sendBody(rabbitMQEndpoint, template);
		return "Message Sent Successfully";
	}

}
