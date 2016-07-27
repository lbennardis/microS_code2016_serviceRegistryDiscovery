package it.luigibennardis.microservice.message.broker;

import it.luigibennardis.microservice.message.Sink;
 





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
		
	
	//private static final Logger log = LoggerFactory.getLogger(ReadReturnTopic.class);

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void helloHole(GenericMessage message) {
        //log.debug("Message: {}", message);
    	System.out.println("GenericMessage"  + message);
    }
        
}
