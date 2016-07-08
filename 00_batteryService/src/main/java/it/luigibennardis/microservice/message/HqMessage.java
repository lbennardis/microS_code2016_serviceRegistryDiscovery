package it.luigibennardis.microservice.message;

import org.springframework.jms.annotation.JmsListener;

import org.springframework.stereotype.Component;

@Component
public class HqMessage {
	/* va bene ma deve essere creata lcoda*/
	
	@JmsListener(destination = "ExpiryQueue")
	public void onMessage(String content) {
		System.out.println("----> " + content);
	}
	
}

