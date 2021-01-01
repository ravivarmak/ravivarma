package ravi.varma.akka.actor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import akka.actor.UntypedActor;
import ravi.varma.akka.model.Employee;

@Component
@Scope("prototype")
public class EmployeeActor extends UntypedActor {
 Logger logger =LoggerFactory.getLogger(EmployeeActor.class);

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Employee) {
            Employee employeeReceived = ((Employee) message);
            logger.info("The employee object received is : "+employeeReceived);
            logger.info("The current thread is "+Thread.currentThread().getName());
        } else {
            unhandled(message);
        }
    }
}
