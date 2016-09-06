package it.luigibennardis.microservice.service;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import it.luigibennardis.microservice.repositories.IBookingInfoRepository;
import it.luigibennardis.microservice.repositories.IBookingNamedQueryRepository;
import it.luigibennardis.microservice.repositories.IStationAddressRepository;
import it.luigibennardis.microservice.repositories.StazioniNamedQueryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.luigibennardis.microservice.domain.Booking;
import it.luigibennardis.microservice.model.TransactionDetails;


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
    
    
    public void  updateNotConfirmedBooking(String idToUpdate) {
		
	    prenotazioniNamedQueryRepository.updateNotConfirmedBooking(idToUpdate);
		
	}
    
 public void  updateQueued(List <Booking> bookInfo) {
		
	 	String idToUpdate = null;
	 	
	 	Iterator<Booking> iterator = bookInfo.iterator();
        
    	while(iterator.hasNext()){
    		Object obj = iterator.next(); 
    		
    		Object[] appo = (Object[])obj;
    		
    		//System.out.println("VALORI ->"  + appo[0]);
    		
    		idToUpdate = (String) appo[0];
    				
    		
    		prenotazioniNamedQueryRepository.updateQueued(idToUpdate);
    		
    	}
	 	
	    
		
	}
}
