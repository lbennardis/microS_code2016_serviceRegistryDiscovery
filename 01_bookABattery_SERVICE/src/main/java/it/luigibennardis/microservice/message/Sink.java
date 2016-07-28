package it.luigibennardis.microservice.message;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {
	
		String INPUT = "confirmBookingTopic";

		@Input(Sink.INPUT)
		SubscribableChannel confirmBookingTopic();

	
	}