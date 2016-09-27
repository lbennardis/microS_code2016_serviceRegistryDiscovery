package it.luigibennardis.microservice.message;

import it.luigibennardis.microservice.model.TransactionDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(IKafkaOutputChannels.class)
public class WriteOutputTopics {
		
	@Autowired
	private  IKafkaOutputChannels kafkaChannel;
	
	
	@Autowired
	public WriteOutputTopics() {
	}
	
    @Autowired
    public WriteOutputTopics(IKafkaOutputChannels kafkaChannel) {
    	//System.out.println("IKafkaChannels constructor WriteReturnTopic");
        this.kafkaChannel = kafkaChannel;
    }
        
    public void writeOnReturnTopic(TransactionDetails dtInfo) {
    	
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	kafkaChannel.writeOnReturnTopic().send(MessageBuilder.withPayload(dtInfo).build()); 
    }
            
    public void writeOnReturnNotConfirmTopic(TransactionDetails dtInfo)  {
    	
    	try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	kafkaChannel.writeNotConfirmTopic().send(MessageBuilder.withPayload(dtInfo).build()); 
    }
   
}