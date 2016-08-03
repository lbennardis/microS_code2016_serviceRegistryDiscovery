package it.luigibennardis.microservice.message.broker;

import it.luigibennardis.microservice.domain.Booking;
import it.luigibennardis.microservice.message.ISinkOutputTopic;
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
@EnableBinding(ISinkOutputTopic.class)
public class WritePendingTopic {
		
	@Autowired
	private  ISinkOutputTopic kafkaChannel;
	
	
	@Autowired
	public WritePendingTopic() {
	}
	
    @Autowired
    public WritePendingTopic(ISinkOutputTopic kafkaChannel) {
    	this.kafkaChannel = kafkaChannel;
    }

        
    public void writePendingTopic(List<Booking> dtInfo) {
    	
    	if (!dtInfo.isEmpty()){
    		kafkaChannel.outputPendingTopic().send(MessageBuilder.withPayload(dtInfo).build()); 
    	}
    }
   
   
}