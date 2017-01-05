package it.redhat.demo.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;

@MessageDriven(name = "ExcpetionThrowsMdb", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/datatype.channel"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class ExcpetionThrowsMdb implements MessageListener {
	
	@Inject
	private Logger log;
	
	@Inject
	private CounterSingleton counter;

	@Override
	public void onMessage(Message message) {
		
		log.info("throws runtime exception for rollback queue for time {}", counter.times());
		throw new RuntimeException("please go to dead letter queue");
		
	}

}
