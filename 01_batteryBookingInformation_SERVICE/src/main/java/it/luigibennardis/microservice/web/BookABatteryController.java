package it.luigibennardis.microservice.web;

import it.luigibennardis.microservice.domain.Booking;
import it.luigibennardis.microservice.repositories.IBookingInfoRepository;
import it.luigibennardis.microservice.repositories.IBookingNamedQueryRepository;

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
	private final IBookingNamedQueryRepository prenotazioniNamedQueryRepository;

    @Autowired
    BookABatteryController(IBookingInfoRepository prenotazioniRepository,
    		IBookingNamedQueryRepository prenotazioniNamedQueryRepository) {
        this.prenotazioniRepository = prenotazioniRepository;
        this.prenotazioniNamedQueryRepository= prenotazioniNamedQueryRepository;
    }
        
	 
			
	@RequestMapping(value = "/lista")
	public List<Booking> listaPrenotazioni() {
				
		return prenotazioniRepository.findAll();
	}
	
	
	 
		
}
