package it.luigibennardis.microservice.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface IKafkaInputChannels {
	
	String INPUT_PENDING_TOPIC = "pendingBookingTopic";

	@Input(IKafkaInputChannels.INPUT_PENDING_TOPIC)
	SubscribableChannel pendingBookingTopic();
		 
	    
}
