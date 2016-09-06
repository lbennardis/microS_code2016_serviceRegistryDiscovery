package it.luigibennardis.microservice.message.broker;

import it.luigibennardis.microservice.domain.Booking;
import it.luigibennardis.microservice.message.ISinkOutputTopic;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
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
    	//***WRITE TO PENDING TOPIC ONLY IF THE LIST IS NOT EMPTY
    	if (!dtInfo.isEmpty()){
    		kafkaChannel.outputPendingTopic().send(MessageBuilder.withPayload(dtInfo).build());
    		
    	}
    }
   
   
}