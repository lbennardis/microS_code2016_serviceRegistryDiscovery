package it.luigibennardis.microservice.message;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface SinkNotConfirmTopic {
	
	/*	
	String INPUT = "confirmBookingTopic";

		@Input(Sink.INPUT)
		SubscribableChannel confirmBookingTopic();

	*/
	
	String INPUT_NOT_CONFIRM_TOPIC = "notConfirmBookingTopic";

	@Input(SinkNotConfirmTopic.INPUT_NOT_CONFIRM_TOPIC)
	SubscribableChannel notConfirmBookingTopic();
	
	}