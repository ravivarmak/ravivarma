package ravi.varma.akka.actor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import akka.actor.UntypedActor;
@Component
@Scope("prototype")
public class LowPriorityEmployeeActor extends UntypedActor {
 Logger logger = LoggerFactory.getLogger(LowPriorityEmployeeActor.class);
	
	@Override
	public void onReceive(Object message) throws Throwable {
		
		logger.info("Message Received is {} ",message);
		logger.info("Current Thread is {}",Thread.currentThread().getName());
	}

}
