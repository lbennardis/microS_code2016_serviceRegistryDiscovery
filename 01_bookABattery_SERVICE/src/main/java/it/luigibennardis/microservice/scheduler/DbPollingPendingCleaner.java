package it.luigibennardis.microservice.scheduler;


import it.luigibennardis.microservice.service.BookingService;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DbPollingPendingCleaner {
	@Autowired
	private ApplicationContext context;
	
    private static final SimpleDateFormat dateFormat = 
        new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    @Scheduled(fixedRate = 30000)
    public void sendMailToCustomers() {

    	System.out.println("---------------------------------------------------------------");
    	System.out.println("DbPollingPendingCleaner Job -> " + dateFormat.format(new Date()));
    	System.out.println("---------------------------------------------------------------");
    	
        BookingService  service = context.getBean(BookingService.class);
    	
        //***COMMENTED FOR DEMO POURPOUSE - PLEASE SET ENABLE 
    	//service.updateExpiredPendingBooking();
    }
}


 