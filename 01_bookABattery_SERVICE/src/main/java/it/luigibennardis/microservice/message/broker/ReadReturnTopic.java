package it.luigibennardis.microservice.message.broker;

import it.luigibennardis.microservice.message.Sink;
 





import it.luigibennardis.microservice.service.BookingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
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
@EnableBinding(Sink.class)
public class ReadReturnTopic {
	
	@Autowired
	private ApplicationContext context;
	
	
    @ServiceActivator(inputChannel = Sink.INPUT)
    public void helloHole(GenericMessage<String> message) {
        
    	String idToUpdate = message.getPayload().toString();
    			
    	System.out.println("GenericMessage "  + idToUpdate);
    	
    	BookingService  service = context.getBean(BookingService.class);
		
    	service.updatePendingBooking(idToUpdate);
    	
    }
        
}
