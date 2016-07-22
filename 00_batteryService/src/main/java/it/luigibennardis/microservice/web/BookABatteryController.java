package it.luigibennardis.microservice.web;

import it.luigibennardis.microservice.domain.Booking;
import it.luigibennardis.microservice.repositories.IBookingInfoRepository;
import java.util.List;
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
    BookABatteryController(IBookingInfoRepository prenotazioniRepository) {
        this.prenotazioniRepository = prenotazioniRepository;
    }
        
	@RequestMapping(value = "/aggiungi/{stazione}/{batteria}/{citta}/{latitudine}/{longitudine}")
	public Booking addBook(@PathVariable String stazione, @PathVariable String batteria,
			 @PathVariable String citta , @PathVariable long latitudine, @PathVariable long longitudine) {
		
		Booking prenotaBatteria = new Booking(stazione + batteria,stazione,citta,latitudine,longitudine);
		
		prenotazioniRepository.saveAndFlush(prenotaBatteria);
			
	    return prenotaBatteria;
	    
	}
			
	@RequestMapping(value = "/lista")
	public List<Booking> listaPrenotazioni() {
				
		return prenotazioniRepository.findAll();
	}
		
}
