package it.luigibennardis.microservice.web;

import it.luigibennardis.microservice.domain.Booking;
import it.luigibennardis.microservice.repositories.IBookingInfoRepository;
import it.luigibennardis.microservice.repositories.IBookingNamedQueryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/prenotazioni")
public class BookABatteryController {
	@Autowired
	private final IBookingInfoRepository prenotazioniRepository;

	@Autowired
	private final IBookingNamedQueryRepository prenotazioniNamedQueryRepository;

    @Autowired
    BookABatteryController(IBookingInfoRepository prenotazioniRepository,
    		IBookingNamedQueryRepository prenotazioniNamedQueryRepository) {
        this.prenotazioniRepository = prenotazioniRepository;
        this.prenotazioniNamedQueryRepository= prenotazioniNamedQueryRepository;
    }
        
	@RequestMapping(value = "/aggiungi/{stazione}/{batteria}/{citta}/{latitudine}/{longitudine}")
	public Booking addBook(@PathVariable String stazione, @PathVariable String batteria,
			 @PathVariable String citta , @PathVariable long latitudine, @PathVariable long longitudine) {
		
		Booking prenotaBatteria = new Booking(stazione + batteria,stazione,citta,latitudine,longitudine,"PENDING");
		
		
		prenotazioniRepository.saveAndFlush(prenotaBatteria);
		
		
		
	    return prenotaBatteria;
	    
	}
			
	@RequestMapping(value = "/lista")
	public List<Booking> listaPrenotazioni() {
				
		return prenotazioniRepository.findAll();
	}
	
	
	@RequestMapping(value = "/updateRecord")
	public List<Booking> updateRecord() {
				
		prenotazioniNamedQueryRepository.updateBooking("d657e220-3e28-4687-97bd-57e8eb63e5b7");
		return prenotazioniRepository.findAll();
	}
		
	
	
	
	
	@RequestMapping(value = "/greeting")
	  public String greet() {
	     
	    List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
	    Random rand = new Random();

	    int randomNum = rand.nextInt(greetings.size());
	    return greetings.get(randomNum);
	  }
	
}
