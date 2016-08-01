package it.luigibennardis.microservice.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface SinkTopic {
	
		
	String INPUT_PENDING_TOPIC = "timerTopic";

	@Input(SinkTopic.INPUT_PENDING_TOPIC)
	SubscribableChannel pendingBookingTopic();
	
		
	String INPUT_CONFIRM_TOPIC = "confirmBookingTopic";

	@Input(SinkTopic.INPUT_NOT_CONFIRM_TOPIC)
	SubscribableChannel confirmBookingTopic();
			
	
	String INPUT_NOT_CONFIRM_TOPIC = "notConfirmBookingTopic";

	@Input(SinkTopic.INPUT_NOT_CONFIRM_TOPIC)
	SubscribableChannel notConfirmBookingTopic();
	
	}