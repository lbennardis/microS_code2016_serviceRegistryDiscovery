package it.luigibennardis.microservice.message.broker;

//import it.luigibennardis.microservice.message.Sink;
 





import it.luigibennardis.microservice.message.ISinkConfirmTopic;
import it.luigibennardis.microservice.model.TransactionDetails;
import it.luigibennardis.microservice.service.BookingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(ISinkConfirmTopic.class)
public class ReadReturnTopic {
	@Autowired
	private ApplicationContext context;
	
	
    @ServiceActivator(inputChannel = ISinkConfirmTopic.INPUT_CONFIRM_TOPIC)
    public void updateConfirmPending(GenericMessage<TransactionDetails> message) {
          
    	// ok per stringhe String idToUpdate = message.getPayload().toString();
    			
    	System.out.println("GenericMessage CONFIRMED TOPIC getTsFoundsReservation --> "  + message.getPayload().getIdFoundsReservation());
    	
    	BookingService  service = context.getBean(BookingService.class);
		
    	
    	//***UPDATE 
    	service.updatePendingBooking(message.getPayload().getIdReservation());
    	
    }
        
	
	  @ServiceActivator(inputChannel = ISinkConfirmTopic.INPUT_NOT_CONFIRM_TOPIC)
	  public void updateNotConfirmPending(GenericMessage<TransactionDetails> message) {
	        
	  	// ok per stringhe String idToUpdate = message.getPayload().toString();
	  			
	  	System.out.println("GenericMessage NOT CONFIRMED TOPIC getTsFoundsReservation --> "  + message.getPayload().getIdFoundsReservation());
	  	
	  	BookingService  service = context.getBean(BookingService.class);
			
	  	
	  	//***UPDATE 
	  	service.updateNotConfirmedBooking(message.getPayload().getIdReservation());
	  	
	  }
  
}