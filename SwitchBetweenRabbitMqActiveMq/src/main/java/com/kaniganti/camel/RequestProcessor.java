

package com.kaniganti.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*Camel processor for Request route*/

@Component
public class RequestProcessor implements Processor {

	private static final Logger logger = LoggerFactory.getLogger(RequestProcessor.class);	
	
	public void process(Exchange exchange) throws Exception {
		logger.info("hi"+exchange.getIn().getExchange().getIn().getBody());
		logger.info("Processed the message\n{} ",exchange.getIn().getBody());
	}
	
	
}




