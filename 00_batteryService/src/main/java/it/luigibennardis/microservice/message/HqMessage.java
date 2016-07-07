package it.luigibennardis.microservice.message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class HqMessage {
	@JmsListener(destination = "accounts")
	public void onMessage(String content) {
		System.out.println("----> " + content);
	}
}

