package it.luigibennardis.microservice.message;
 


 
import it.luigibennardis.microservice.model.Booking;
import it.luigibennardis.microservice.model.TransactionDetails;
 
 



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
@EnableBinding(IKafkaInputChannels.class)
public class ReadTopics {
	
	
	
	@Autowired
	private ApplicationContext context;
	
    
    @StreamListener(IKafkaInputChannels.INPUT_PENDING_TOPIC)
    public void readPendingTopic(GenericMessage<List <Booking>>  bookInfo) {
    	
    	WriteReturnTopic  service = context.getBean(WriteReturnTopic.class);
		
    	
    	//Iterator<Booking> iterator = ((List<Booking>) bookInfo).iterator();
		
    	System.out.println("READ   	bookInfo ->"  + bookInfo.getPayload().size());
    	//System.out.println("READ   	bookInfo id ->"  + bookInfo.getPayload().get(0))).getId()    );
    	
    	/Iterator<Booking> iterator = ((List<Booking>) bookInfo).iterator();
    	
    	//while(iterator.hasNext()){
			//Object obj = iterator.next();
		
			//System.out.println("READ   	bookInfo ->"  + obj.toString());
	    	
			 
			@SuppressWarnings("unchecked")
			//ArrayList<String> appo = 	(ArrayList<String>) obj;
			//System.out.println("READ   	appo .size				->" + appo.get(0));
			
			//Booking appo = (Booking) obj;
			
			//System.out.println("READ   					->" + appo.getId());
			//System.out.println("CHECK AVAILABLE FUNDS   ->" + appo.get(0));
			
			//***CHECK AVAILABLE FUNDS 
			//System.out.println("READ   					->" + appo.get(0));
			//System.out.println("CHECK AVAILABLE FUNDS   ->" + appo.get(0));
			
			//service.writeOnReturnTopic(obj.toString());
			String idTransaction = UUID.randomUUID().toString();
			java.util.Date date = new java.util.Date();
	        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
	        
			//TransactionDetails dt = new TransactionDetails(appo.getId(), idTransaction,timestamp );
			
			//WRITE OK TOPIC
			//service.writeOnReturnTopic(dt);
			
			//WRITE KO TOPIC
			//service.writeOnReturnNotConfirmTopic(dt);
			
			//service.writeOnReturnTopic(appo);
			
    	//}
              
	}
    
}    
    
   