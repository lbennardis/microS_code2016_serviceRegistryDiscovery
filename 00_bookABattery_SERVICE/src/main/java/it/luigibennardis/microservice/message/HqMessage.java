package it.luigibennardis.microservice.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HqMessage {
	/* va bene ma deve essere creata lcoda*/
	/*
	@JmsListener(destination = "ExpiryQueue")
	public void onMessage(String content) {
		System.out.println("----> " + content);
	}
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Scheduled(fixedDelay = 1000L)
	public void send() {
	    this.jmsTemplate.convertAndSend("ExpiryQueue", "Hello from external app");
	}
	*/
}

