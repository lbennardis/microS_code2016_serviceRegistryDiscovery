package it.luigibennardis.microservice.message.broker;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(Source.class)
public class PublishToKafka {
	
	@Bean
	@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
	public MessageSource<TimeInfo> timerMessageSource() {
		
    	// CALL SERVICE THAT RETURNS A LIST OF BOOKING RECORD IN PENDING STATE 
    	
    	
    	
        
    	TimeInfo timeInfo = new TimeInfo(new Date().getTime()+"","Label");
    	
    	
    	
    	return () -> MessageBuilder.withPayload(timeInfo).build();
    	}
	
	public static class TimeInfo{
		
		private String time;
		private String label;
		
		public TimeInfo(String time, String label) {
			super();
			this.time = time;
			this.label = label;
		}

		public String getTime() {
			return time;
		}

		public String getLabel() {
			return label;
		}
		
	}
}