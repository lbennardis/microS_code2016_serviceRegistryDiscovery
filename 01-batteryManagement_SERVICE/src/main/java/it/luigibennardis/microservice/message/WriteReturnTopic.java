package it.luigibennardis.microservice.message;

import it.luigibennardis.microservice.model.TransactionDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(IKafkaOutputChannels.class)
public class WriteReturnTopic {
		
	@Autowired
	private  IKafkaOutputChannels kafkaChannel;
	
	
	@Autowired
	public WriteReturnTopic() {
	}
	
    @Autowired
    public WriteReturnTopic(IKafkaOutputChannels kafkaChannel) {
    	System.out.println("IKafkaChannels constructor WriteReturnTopic");
        this.kafkaChannel = kafkaChannel;
    }

        
    public void writeOnReturnTopic(TransactionDetails dtInfo) {
    	kafkaChannel.writeOnReturnTopic().send(MessageBuilder.withPayload(dtInfo).build()); 
    }
    
    
    
    public void writeOnReturnNotConfirmTopic(TransactionDetails dtInfo) {
    	kafkaChannel.writeNotConfirmTopic().send(MessageBuilder.withPayload(dtInfo).build()); 
    }
   
}