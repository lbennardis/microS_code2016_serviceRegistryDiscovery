package it.luigibennardis.microservice.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface IKafkaInputChannels {
	
	String INPUT_PENDING_TOPIC = "timerTopic";

	@Input(IKafkaInputChannels.INPUT_PENDING_TOPIC)
	SubscribableChannel pendingBookingTopic();
		 
	    
}
