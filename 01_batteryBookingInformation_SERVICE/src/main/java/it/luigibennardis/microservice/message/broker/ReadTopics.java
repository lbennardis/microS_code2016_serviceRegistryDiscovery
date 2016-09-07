package it.luigibennardis.microservice.message.broker;

import it.luigibennardis.microservice.domain.Booking;
import it.luigibennardis.microservice.message.IKafkaTopics;
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
@EnableBinding(IKafkaTopics.class)
public class ReadTopics {
	
	@Autowired
	private ApplicationContext context;
	
	
	//***READ ALL CONFIRMED MESSAGES ON CONFIRMED TOPIC
    @ServiceActivator(inputChannel = IKafkaTopics.INPUT_CONFIRM_TOPIC)
    public void readConfirmTopic(GenericMessage<TransactionDetails> message) {
    
		MongoDbService  service = context.getBean(MongoDbService.class);
		
		//***UPDATE DOCUMENT ON MONGO DB
		service.updateConfirmedRecord(message.getPayload().getIdReservation(),message.getPayload().getIdFoundsReservation());;
			
    }
    
    
    //***READ ALL CONFIRMED MESSAGES ON NOT CONFIRMED TOPIC
    @ServiceActivator(inputChannel = IKafkaTopics.INPUT_NOT_CONFIRM_TOPIC)
    public void readNotConfirmTopic(GenericMessage<TransactionDetails> message) {
      
		
    	MongoDbService  service = context.getBean(MongoDbService.class);
    	
    	//***UPDATE DOCUMENT ON MONGO DB
		service.updateNotConfirmedRecord(message.getPayload().getIdReservation());;
	
	}
    
    //***READ ALL PENDING MESSAGES ON PENDING TOPIC
    @StreamListener(IKafkaTopics.INPUT_PENDING_TOPIC)
    public void readPendingTopic(GenericMessage<List <Booking>>  bookInfo) {
    	
    	Iterator<Booking> iterator = bookInfo.getPayload().iterator();
        
    	while(iterator.hasNext()){
    		Object obj = iterator.next();
    				    		
    		Object[] appo = (Object[])obj;
    		
    		//System.out.println("VALORI ->"  + appo[0]);
    		
    		String bookId =  appo[0].toString(); 
    		 		
    		MongoDbService  service = context.getBean(MongoDbService.class);
    		
    		//***INSERT NEW DOCUMENT ON MONGO DB
    		service.insertDocument(bookId);
    		
    		} 
              
	}
    
}    
     