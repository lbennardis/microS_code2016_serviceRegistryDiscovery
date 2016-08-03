package it.luigibennardis.microservice.message;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ISinkConfirmTopic {
	
		
	String INPUT_CONFIRM_TOPIC = "confirmBookingTopic";

	@Input(ISinkConfirmTopic.INPUT_CONFIRM_TOPIC)
	SubscribableChannel confirmBookingTopic();
	
	
	String INPUT_NOT_CONFIRM_TOPIC = "notConfirmBookingTopic";

	@Input(ISinkConfirmTopic.INPUT_NOT_CONFIRM_TOPIC)
	SubscribableChannel notConfirmBookingTopic();
	
	}