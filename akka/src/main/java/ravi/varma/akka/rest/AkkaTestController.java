package ravi.varma.akka.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import ravi.varma.akka.config.SpringExtension;
import ravi.varma.akka.model.Employee;

@RestController
@RequestMapping("/api")
public class AkkaTestController {
	
    @Autowired
	ActorSystem system;	
	@PostMapping("/emp")
	public void postData(@RequestBody Employee emploeyee) {
		
		ActorRef empRef = system.actorOf(SpringExtension.SPRING_EXTENSION_PROVIDER.get(system)
				  .props("employeeActor"), "emp");
		empRef.tell(emploeyee, empRef);
		
		ActorRef empRef2 = system.actorOf(SpringExtension.SPRING_EXTENSION_PROVIDER.get(system)
				  .props("lowPriorityEmployeeActor"), "emp2");
		empRef2.tell(emploeyee, empRef2);
		
		
	}
}
