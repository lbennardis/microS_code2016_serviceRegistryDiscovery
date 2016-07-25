package it.luigibennardis.microservice.web;



 
import it.luigibennardis.microservice.domain.StationAddress;
 
import it.luigibennardis.microservice.domain.Booking;
import it.luigibennardis.microservice.domain.Users;
import it.luigibennardis.microservice.repositories.IStationAddressRepository;
import it.luigibennardis.microservice.repositories.IBookingInfoRepository;
import it.luigibennardis.microservice.repositories.StazioniNamedQueryRepository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

	
	private final StazioniNamedQueryRepository stazioniRepository;
	private final IStationAddressRepository indirizziRepository;
	
    @Autowired
    UsersController(StazioniNamedQueryRepository stazioniRepository, IStationAddressRepository indirizziRepository ) {
    	this.stazioniRepository = stazioniRepository;
    	this.indirizziRepository = indirizziRepository;
        
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/indirizzi")
    ResponseEntity<List<StationAddress>> listaIndirizzi() {
        
    	List<StationAddress> indirizzi = indirizziRepository.findAll();
    	
    	
    	
    	return new ResponseEntity<>(indirizzi, HttpStatus.OK);
    	//return null;
    	//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/trovaStazionePiuVicina/{latitudine}/{longitudine}/{distanza}")
    ResponseEntity<List<StationAddress>> trovaStazionepiuVicina(@PathVariable long latitudine,
    		@PathVariable long longitudine, long distanza) {
        
    	List<StationAddress> indirizzi = stazioniRepository.findNearest(latitudine,longitudine,Double.valueOf(distanza));
    	
    	//return new ResponseEntity<>(result, HttpStatus.CREATED);
        
        
    	
    	return new ResponseEntity<>(indirizzi, HttpStatus.OK);
    	
    	//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
   
}