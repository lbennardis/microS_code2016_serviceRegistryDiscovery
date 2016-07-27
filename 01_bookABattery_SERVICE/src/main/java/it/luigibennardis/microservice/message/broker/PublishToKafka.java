package it.luigibennardis.microservice.message.broker;

import it.luigibennardis.microservice.domain.Booking;

import it.luigibennardis.microservice.repositories.IBookingInfoRepository;
import it.luigibennardis.microservice.service.GetPendingBookingInfo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class PublishToKafka {
	
	
	@Autowired
	private ApplicationContext context;
	
		
	@Bean
	@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
	public MessageSource <List <Booking>> timerMessageSource() {
				
    	  	
		GetPendingBookingInfo  service = context.getBean(GetPendingBookingInfo.class);
		
		//List<Booking> listaItem = service.getPendingBooking();
		
		List <Booking>  listaItem = service.getPendingBooking();
		
		return () -> MessageBuilder.withPayload(listaItem).build();
    	}
	
	
}