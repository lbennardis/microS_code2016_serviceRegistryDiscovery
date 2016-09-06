package it.luigibennardis.microservice.message;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface ISinkOutputTopic {
	
		
	String OUPUT_PENDING_TOPIC = "pendingBookingTopic";

	@Output(ISinkOutputTopic.OUPUT_PENDING_TOPIC)
	SubscribableChannel outputPendingTopic();
	
	}