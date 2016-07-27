package it.luigibennardis.microservice.service;

import java.util.List;

import it.luigibennardis.microservice.repositories.IBookingInfoRepository;
import it.luigibennardis.microservice.repositories.IBookingNamedQueryRepository;
import it.luigibennardis.microservice.repositories.IStationAddressRepository;
import it.luigibennardis.microservice.repositories.StazioniNamedQueryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.luigibennardis.microservice.domain.Booking;


@Service
public class GetPendingBookingInfo {

	@Autowired
	private final IBookingNamedQueryRepository prenotazioniRepository;

    @Autowired
    GetPendingBookingInfo(IBookingNamedQueryRepository prenotazioniRepository) {
        this.prenotazioniRepository = prenotazioniRepository;
    }
    
       
    
    
    /*public List<Booking> getPendingBooking() {
		
    	//List<BookingMessage> returnList = prenotazioniRepository.findPending("PENDING");
    	List<Booking> returnList = prenotazioniRepository.findPending();
    	
    	// non si sa dove ridirige System.out.println("returnList -> " + returnList.size());
    	
    	return returnList;*/
    	
    	 public List <Booking>  getPendingBooking() {
    			
    	    	//List<BookingMessage> returnList = prenotazioniRepository.findPending("PENDING");
    		 //List<Booking> returnList = prenotazioniRepository.findPending();
    		 List <Booking> returnList = prenotazioniRepository.findPending();
 	    	
    	    	// non si sa dove ridirige System.out.println("returnList -> " + returnList.size());
    	    	
    	    	return returnList;
    	    	
    	    	
	}

	
}
