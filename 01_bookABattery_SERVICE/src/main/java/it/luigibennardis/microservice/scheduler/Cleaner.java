package it.luigibennardis.microservice.scheduler;


import it.luigibennardis.microservice.message.Sink;
import it.luigibennardis.microservice.service.BookingService;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Cleaner {
	@Autowired
	private ApplicationContext context;
	
    private static final SimpleDateFormat dateFormat = 
        new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    @Scheduled(fixedRate = 25000)
    public void sendMailToCustomers() {

        System.out.println("CLEANER PENDING Job ran at " 
            + dateFormat.format(new Date()));
        
        BookingService  service = context.getBean(BookingService.class);
    	
    	service.updateExpiredPendingBooking();
    }
}


 