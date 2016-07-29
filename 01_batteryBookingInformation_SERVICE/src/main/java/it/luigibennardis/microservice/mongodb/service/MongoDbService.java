package it.luigibennardis.microservice.mongodb.service;

 
import java.util.List;

import it.luigibennardis.microservice.domain.Booking;
import it.luigibennardis.microservice.mongodb.repositories.IDetailedReservation;
import it.luigibennardis.microservice.mongodbentity.DetailedReservation;
import it.luigibennardis.microservice.repositories.IBookingNamedQueryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MongoDbService {
	
	@Autowired
	private final IDetailedReservation dtRepository;

	
    @Autowired
    MongoDbService(IDetailedReservation dtRepository) {
        this.dtRepository= dtRepository;
    }
    
	public void testMongo() {

		dtRepository.deleteAll();

		// save a couple of DetailedReservation
		dtRepository.save(new DetailedReservation("id001", "tran001"));
		dtRepository.save(new DetailedReservation("id002", "tran002"));
		
		// fetch all DetailedReservation
		System.out.println("DetailedReservation found with findAll():");
		System.out.println("-------------------------------");
		for (DetailedReservation dtRes : dtRepository.findAll()) {
			System.out.println(dtRes);
		}
		System.out.println();

		// fetch an individual customer
		//System.out.println("Customer found with findByFirstName('Alice'):");
		//System.out.println("--------------------------------");
		//System.out.println(repository.findByFirstName("Alice"));

		//System.out.println("Customers found with findByLastName('Smith'):");
		//System.out.println("--------------------------------");
		//for (Customer customer : repository.findByLastName("Smith")) {
		//	System.out.println(customer);
		//}

	}
}

/*
@Service
public class BookingService {

	@Autowired
	private final IBookingNamedQueryRepository prenotazioniNamedQueryRepository;

	
    @Autowired
    BookingService(IBookingNamedQueryRepository prenotazioniNamedQueryRepository) {
        this.prenotazioniNamedQueryRepository= prenotazioniNamedQueryRepository;
    }
    
       
    public List <Booking>  getPendingBooking() {
    			
    	    List <Booking> returnList = prenotazioniNamedQueryRepository.findPending();
 		    	
    	    return returnList;
    }

    public void  updatePendingBooking(String idToUpdate) {
		
	    prenotazioniNamedQueryRepository.updateBooking(idToUpdate);
		
	}
    
    public void  updateExpiredPendingBooking() {
		
	    prenotazioniNamedQueryRepository.deleteExpiredBooking();;
		
	}
}*/
