package it.luigibennardis.microservice.message;
 
 
import it.luigibennardis.microservice.model.Booking;
import it.luigibennardis.microservice.model.TransactionDetails;
 
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(IKafkaInputChannels.class)
public class ReadInputTopic {
		
	
	@Autowired
	private ApplicationContext context;
	
    
    @StreamListener(IKafkaInputChannels.INPUT_PENDING_TOPIC)
    public void readPendingTopic(GenericMessage<List <Booking>>  bookInfo) {
    	    	    	
    	WriteOutputTopics  service = context.getBean(WriteOutputTopics.class);
		
    	//System.out.println("READ   	bookInfo ->"  + bookInfo.getPayload().size());
    	
    	Iterator<Booking> iterator = bookInfo.getPayload().iterator();
        
    	int i = 1;
    	while(iterator.hasNext()){
    		Object obj = iterator.next(); 
    		
    		Object[] appo = (Object[])obj;
    		
    		//System.out.println("VALORI ->"  + appo[0]);
    		
    		String idTransaction = UUID.randomUUID().toString();
			java.util.Date date = new java.util.Date();
	        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
	        
			TransactionDetails dt = new TransactionDetails(appo[0].toString(), idTransaction,timestamp );
			
			//***FOR DEMO PURPOUSE ->ODD MESSAGES GOES TO CONFIRM_TOPIC, WHILE EVEN TO NOT_CONFIRM_TOPIC
			if (i % 2 ==1){
				
				service.writeOnReturnNotConfirmTopic(dt);
			}else{
				
				service.writeOnReturnTopic(dt);
			}
			i++;
    	}
    	     	 
              
	}
    
}    
    
   