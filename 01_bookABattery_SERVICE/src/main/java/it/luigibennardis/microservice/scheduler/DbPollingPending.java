package it.luigibennardis.microservice.scheduler;


 
import it.luigibennardis.microservice.domain.Booking;
import it.luigibennardis.microservice.message.broker.WritePendingTopic;
import it.luigibennardis.microservice.service.BookingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DbPollingPending {
	
	@Autowired
	private ApplicationContext context;
	
     
    @Scheduled(fixedRate = 10000)
    public void pollingPending() {

        BookingService  service = context.getBean(BookingService.class);
        WritePendingTopic  serviceTopic = context.getBean(WritePendingTopic.class);
			
		List <Booking>  listaItem = service.getPendingBooking();
		
		serviceTopic.writePendingTopic(listaItem);
    	
    }
}


 