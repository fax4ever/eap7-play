package it.redhat.demo.rest;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.slf4j.Logger;

import it.redhat.demo.mdb.CounterSingleton;

@Path("")
@Stateless
public class RestService {
	
	@Resource(lookup="java:/jms/queue/datatype.channel")
    private Queue dataTypeQueue;
	
	@Resource(lookup="java:/jms/queue/no.consumer")
    private Queue noConsumerQueue;
	
	@Inject
    private JMSContext jms;
	
	@Inject
	private Logger log;
	
	@Inject
	private CounterSingleton counter;

	@GET
	public String ciao() {
		return "ciao";
	}
	
	@DELETE
	public Integer deadLetter() {
		log.info("sending message to queue");
		counter.reset();
		jms.createProducer().send(dataTypeQueue, "runtime exception --> dead letter");
		return counter.getTimes();
	}
	
	@PUT
	public void expiry() {
		log.info("sending message to queue with no consumer");
	
		JMSProducer producer = jms.createProducer();
		producer.setTimeToLive(1000);
		
		producer.send(noConsumerQueue, "timeout --> expiry");
	}
	
}
