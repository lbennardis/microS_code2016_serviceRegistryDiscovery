package it.luigibennardis.microservice.message.broker;

import it.luigibennardis.microservice.domain.Booking;
import it.luigibennardis.microservice.message.SinkTopic;
import it.luigibennardis.microservice.model.TransactionDetails;
import it.luigibennardis.microservice.mongodb.service.MongoDbService;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.annotation.ServiceActivator;
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
    public void readPendingTopic(GenericMessage<List <Booking>>  bookInfo) {
    	      
	    	
    	//System.out.println("READ   	bookInfo ->"  + bookInfo.getPayload().size());
    	
    	Iterator<Booking> iterator = bookInfo.getPayload().iterator();
        
    	while(iterator.hasNext()){
    		Object obj = iterator.next();
    				
    		
    		Object[] appo = (Object[])obj;
    		
    		System.out.println("VALORI ->"  + appo[0]);
    		
    		String bookId =  appo[0].toString(); 
    		
    		//***CHECK AVAILABLE FUNDS 
    		System.out.println("readPendingTopic bookId -> " + bookId);
    		 		
    		MongoDbService  service = context.getBean(MongoDbService.class);
    		
    		service.insertDocument(bookId);
    		
    		
    		} 
              
	}
    
}    
     