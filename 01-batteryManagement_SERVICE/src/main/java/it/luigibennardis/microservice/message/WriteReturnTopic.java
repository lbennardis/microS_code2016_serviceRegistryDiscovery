package it.luigibennardis.microservice.message;

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
@EnableBinding(IKafkaChannels.class)
public class WriteReturnTopic {
		
	@Autowired
	private  IKafkaChannels kafkaChannel;
	
	
	@Autowired
	public WriteReturnTopic() {
        //this.kafkaChannel = kafkaChannel;
		System.out.println("default constructor WriteReturnTopic");
    }
	
    @Autowired
    public WriteReturnTopic(IKafkaChannels kafkaChannel) {
    	System.out.println("IKafkaChannels constructor WriteReturnTopic");
        this.kafkaChannel = kafkaChannel;
    }

    public void sayHello(String name) {
    	kafkaChannel.writeTopic().send(MessageBuilder.withPayload("Ciao").build()); 
    	//source.output().send(MessageBuilder.withPayload("Ciao").build());
    }
}
