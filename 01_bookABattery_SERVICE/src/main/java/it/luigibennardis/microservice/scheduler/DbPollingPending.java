package it.luigibennardis.microservice.scheduler;


 
import it.luigibennardis.microservice.domain.Booking;
import it.luigibennardis.microservice.message.broker.WritePendingTopic;
import it.luigibennardis.microservice.service.BookingService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DbPollingPending {
	
	@Autowired
	private ApplicationContext context;
	
	 private static final SimpleDateFormat dateFormat = 
		        new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	 
    @Scheduled(fixedRate = 30000)
    public void pollingPending() {

    	System.out.println("----------------------------------------------------------");
    	System.out.println("DbPollingPending Job -> " + dateFormat.format(new Date()));
    	System.out.println("----------------------------------------------------------");
    	 
    	BookingService  service = context.getBean(BookingService.class);
        WritePendingTopic  serviceTopic = context.getBean(WritePendingTopic.class);
			
		List <Booking>  listaItem = service.getPendingBooking();
		
		serviceTopic.writePendingTopic(listaItem);
		
		service.updateQueued(listaItem);
    }
}


 