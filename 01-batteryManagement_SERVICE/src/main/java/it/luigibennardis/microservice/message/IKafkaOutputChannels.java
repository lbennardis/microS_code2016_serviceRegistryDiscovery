package it.luigibennardis.microservice.message;

 
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
 
public interface IKafkaOutputChannels {
	
	
	@Output("confirmBookingTopic")
    MessageChannel writeOnReturnTopic();
    
	@Output("notConfirmBookingTopic")
    MessageChannel writeNotConfirmTopic();
    
    
	    
}
