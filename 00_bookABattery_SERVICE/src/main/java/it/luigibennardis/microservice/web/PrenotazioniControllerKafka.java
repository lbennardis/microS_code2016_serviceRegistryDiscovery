package it.luigibennardis.microservice.web;

import javax.transaction.Transactional;


import it.luigibennardis.microservice.domain.Booking;
import it.luigibennardis.microservice.message.MessageController;
import it.luigibennardis.microservice.repositories.IBookingInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Transactional
@RequestMapping(value = "/prenotazioniWriteMessage")
public class PrenotazioniControllerKafka {
	@Autowired
	private final IBookingInfoRepository prenotazioniRepository;
	
	@Autowired
	private  MessageController callKafka ;
		
    @Autowired
    PrenotazioniControllerKafka(IBookingInfoRepository prenotazioniRepository) {
        this.prenotazioniRepository = prenotazioniRepository;
    }
    
    
	@RequestMapping(value = "/aggiungi/{stazione}/{batteria}/{citta}/{latitudine}/{longitudine}")
	public Booking addBook(@PathVariable String stazione, @PathVariable String batteria,
			 @PathVariable String citta , @PathVariable long latitudine, @PathVariable long longitudine) {
		
		
		Booking prenotaBatteria = new Booking(stazione + batteria,stazione,citta,latitudine,longitudine);
		
		prenotazioniRepository.saveAndFlush(prenotaBatteria);
		
		String ret = "";//callKafka.writeMessage(new CreditCardInfo(prenotaBatteria.getId(), "1234 5678 3456 7878"));
		
		System.out.println("KAFKA MESSAGE : >" + ret);
		
		System.out.println(prenotaBatteria.getId());
		
		if (ret.equals("ok")) {
			
			//ECCEZIONE->ROLLBACK TRANSAZIONE
			throw new RuntimeException("SIMULAZIONE DI ROLLBACK ULTIMA TRANSAZIONE");
		}

	    return prenotaBatteria;
	    
	}
	
	
	 
}