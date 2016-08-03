package it.luigibennardis.microservice.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface IKafkaOutputChannels {
	
	/*
	@Input("timerTopic")
	SubscribableChannel readTopic();
	*/
	
	@Output("confirmBookingTopic")
    MessageChannel writeOnReturnTopic();
    
	@Output("notConfirmBookingTopic")
    MessageChannel writeNotConfirmTopic();
    
    
	    
}
