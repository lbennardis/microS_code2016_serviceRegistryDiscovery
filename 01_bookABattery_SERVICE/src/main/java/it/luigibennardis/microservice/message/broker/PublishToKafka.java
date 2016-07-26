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
	
	/*
	@Autowired
	private final IBookingInfoRepository prenotazioniRepository;

    @Autowired
    PublishToKafka(IBookingInfoRepository prenotazioniRepository) {
        this.prenotazioniRepository = prenotazioniRepository;
    }
	*/
    
	
	
	@Bean
	@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
	//public MessageSource<TimeInfo> timerMessageSource() {
		public MessageSource<Booking> timerMessageSource() {
				
    	// CALL SERVICE THAT RETURNS A LIST OF BOOKING RECORD IN PENDING STATE 
		//Booking prenotaBatteria = null;
	    
	    //List <Booking> listItems;
	    //listItems = prenotazioniRepository.findAll();
    	  	
		GetPendingBookingInfo  service = context.getBean(GetPendingBookingInfo.class);
		
		List <Booking> listaItem = service.getPendingBooking();
		
		
    	TimeInfo timeInfo = new TimeInfo(new Date().getTime()+"","Label");
    	    	
    	
    	//return () -> MessageBuilder.withPayload(timeInfo).build();
    	return () -> MessageBuilder.withPayload(listaItem.get(0)).build();
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