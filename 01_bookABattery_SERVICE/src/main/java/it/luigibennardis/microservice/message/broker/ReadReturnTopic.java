package it.luigibennardis.microservice.message.broker;

import it.luigibennardis.microservice.message.IKafkaChannels;
 




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
@EnableBinding(IKafkaChannels.class)
public class ReadReturnTopic {
		
	@Autowired
	private  IKafkaChannels kafkaChannel;
	
	
	@Autowired
	public ReadReturnTopic() {
        
    }
	
    @Autowired
    public ReadReturnTopic(IKafkaChannels kafkaChannel) {
    	this.kafkaChannel = kafkaChannel;
    }
    @ServiceActivator(inputChannel = Sink.INPUT)
    public void readTopic(GenericMessage message) {
    	System.out.println("readOnReturnTopic " +message);
    	 
    	
    	//kafkaChannel.writeTopic().send(MessageBuilder.withPayload(idRecordToUpdate).build()); 
    	//source.output().send(MessageBuilder.withPayload("Ciao").build());
    }
    
    
   
        
}
