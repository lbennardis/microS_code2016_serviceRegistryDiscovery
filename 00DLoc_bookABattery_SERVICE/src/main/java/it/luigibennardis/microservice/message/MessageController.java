package it.luigibennardis.microservice.message;

//import it.luigibennardis.microservice.domain.CreditCardInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
//@EnableBinding(Source.class)
public class MessageController {
	
	/*
	@Autowired
	private Source source;
	
	@Autowired
	public MessageController () {
	}
		 	
	public String writeMessage(CreditCardInfo ccInfo){
		 				
		source.output().send(MessageBuilder.withPayload(ccInfo).build());
		 
		return "ok";			
	}
	*/	
	
}
