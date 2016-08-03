package it.luigibennardis.microservice.message.broker;

import it.luigibennardis.microservice.message.ISinkConfirmTopic;
import it.luigibennardis.microservice.model.TransactionDetails;
import it.luigibennardis.microservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(ISinkConfirmTopic.class)
public class ReadReturnTopic {
	@Autowired
	private ApplicationContext context;
	
	
    @ServiceActivator(inputChannel = ISinkConfirmTopic.INPUT_CONFIRM_TOPIC)
    public void updateConfirmPending(GenericMessage<TransactionDetails> message) {
        
    	BookingService  service = context.getBean(BookingService.class);
		    	
    	//***UPDATE TO CONFIRMED PENDING RECORDS 
    	service.updatePendingBooking(message.getPayload().getIdReservation());
    	
    }
        
	
	  @ServiceActivator(inputChannel = ISinkConfirmTopic.INPUT_NOT_CONFIRM_TOPIC)
	  public void updateNotConfirmPending(GenericMessage<TransactionDetails> message) {
	        
	  	
	  	BookingService  service = context.getBean(BookingService.class);
				  	
	  	//***UPDATE TO REJECTED PENDING RECORDS 
	  	service.updateNotConfirmedBooking(message.getPayload().getIdReservation());
	  	
	  }
  
}