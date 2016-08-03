package it.luigibennardis.microservice.message.broker;

import it.luigibennardis.microservice.domain.Booking;
 
 
 
import it.luigibennardis.microservice.message.SinkTopic;
 


 
import it.luigibennardis.microservice.model.TransactionDetails;
import it.luigibennardis.microservice.mongodb.service.MongoDbService;
 


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import kafka.message.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
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
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(SinkTopic.class)
public class ReadTopics {
	
	
	
	@Autowired
	private ApplicationContext context;
	
	
    @ServiceActivator(inputChannel = SinkTopic.INPUT_CONFIRM_TOPIC)
    public void readConfirmTopic(GenericMessage<TransactionDetails> message) {
    
			
	System.out.println("GenericMessage CONFIRMED TOPIC getTsFoundsReservation --> "  
			+ message.getPayload().getIdFoundsReservation());
		
	MongoDbService  service = context.getBean(MongoDbService.class);
	
	service.updateConfirmRecord(message.getPayload().getIdReservation(),message.getPayload().getIdFoundsReservation());;
		
	
    }
    
    
    @ServiceActivator(inputChannel = SinkTopic.INPUT_NOT_CONFIRM_TOPIC)
    public void readNotConfirmTopic(GenericMessage<TransactionDetails> message) {
      
	System.out.println("GenericMessage NOT CONFIRMED TOPIC getTsFoundsReservation --> "  
			+ message.getPayload().getIdFoundsReservation());
	
	
	MongoDbService  service = context.getBean(MongoDbService.class);
	
	service.existRecord(message.getPayload().getIdReservation());;
	
	}
    
    
    @StreamListener(SinkTopic.INPUT_PENDING_TOPIC)
    public void readPendingTopic(List <Booking>  bookInfo) {
    	      
	    	
    	System.out.println("READ   	bookInfo ->"  + bookInfo.size());
    	
    	Iterator<Booking> iterator = bookInfo.iterator();
    	
        while(iterator.hasNext()){
    		Object obj = iterator.next();
    				
    		@SuppressWarnings("unchecked")
    		ArrayList<String> appo = 	(ArrayList<String>) obj;
    		
    		String bookId = appo.get(0); 
    		
    		//***CHECK AVAILABLE FUNDS 
    		System.out.println("readPendingTopic bookId -> " + appo.get(0));
    		 		
    		MongoDbService  service = context.getBean(MongoDbService.class);
    		
    		service.insertDocument(bookId);
    		
    		
    		} 
              
	}
    
}    
    
    
/*String INPUT_PENDING_TOPIC = "timerTopic";

	@Input(SinkTopic.INPUT_PENDING_TOPIC)
	SubscribableChannel pendingBookingTopic();
	
		
	String INPUT_CONFIRM_TOPIC = "confirmBookingTopic";

	@Input(SinkTopic.INPUT_NOT_CONFIRM_TOPIC)
	SubscribableChannel confirmBookingTopic();
			
	
	String INPUT_NOT_CONFIRM_TOPIC = "notConfirmBookingTopic";

	@Input(SinkTopic.INPUT_NOT_CONFIRM_TOPIC)
	SubscribableChannel notConfirmBookingTopic();
	*/
    
    