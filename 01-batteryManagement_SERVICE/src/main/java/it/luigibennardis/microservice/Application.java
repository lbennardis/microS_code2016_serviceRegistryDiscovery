package it.luigibennardis.microservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.luigibennardis.microservice.message.WriteReturnTopic;
import it.luigibennardis.microservice.model.Booking;
 







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;

@SpringBootApplication
@EnableBinding(Sink.class)
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	
	
	
	@Autowired
	private ApplicationContext context;
	
		
				
    	  	
		
		
	
	@StreamListener(Sink.INPUT)
	public void loggerSink(List <Booking> bookInfo) {
		
		//check not null
		WriteReturnTopic  service = context.getBean(WriteReturnTopic.class);
		
		Iterator<Booking> iterator = bookInfo.iterator();
						
		 
		while(iterator.hasNext()){
			Object obj = iterator.next();
					
			@SuppressWarnings("unchecked")
			ArrayList<String> appo = 	(ArrayList<String>) obj;
			
			//***CHECK AVAILABLE FUNDS 
			
			
			//service.writeOnReturnTopic(obj.toString());
			service.writeOnReturnTopic(appo.get(0));
			
			 
	           
		}
		
		
			
	}
		
	
	
		
		 
		
		
}
	



