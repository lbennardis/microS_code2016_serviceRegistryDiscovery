package it.luigibennardis.microservice.web;

import javax.transaction.Transactional;

import it.luigibennardis.microservice.domain.CreditCardInfo;
import it.luigibennardis.microservice.domain.Prenotazioni;
import it.luigibennardis.microservice.message.MessageController;
import it.luigibennardis.microservice.repositories.IBookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Transactional
@RequestMapping(value = "/prenotazioniWriteMessageHQ")
public class PrenotazioniControllerHornetQ {
	@Autowired
	private final IBookRepository prenotazioniRepository;
	
	//@Autowired
	//private  MessageController callKafka ;
	
	
	private final JmsTemplate jmsTemplate;
    
	
    @Autowired
    PrenotazioniControllerHornetQ(IBookRepository prenotazioniRepository,JmsTemplate jmsTemplate) {
        this.prenotazioniRepository = prenotazioniRepository;
        this.jmsTemplate = jmsTemplate;
    }
    
    
    
	@RequestMapping(value = "/aggiungi/{stazione}/{batteria}/{citta}/{latitudine}/{longitudine}")
	public Prenotazioni addBook(@PathVariable String stazione, @PathVariable String batteria,
			 @PathVariable String citta , @PathVariable long latitudine, @PathVariable long longitudine) {
		
		
		Prenotazioni prenotaBatteria = new Prenotazioni(stazione + batteria,stazione,citta,latitudine,longitudine);
		
		prenotazioniRepository.saveAndFlush(prenotaBatteria);
		
		String ret = "o";
				
		//System.out.println("KAFKA MESSAGE : >" + ret);
		//new CreditCardInfo(prenotaBatteria.getId(), "1234 5678 3456 7878")
		this.jmsTemplate.convertAndSend("accounts", "messaggio" );
		
		System.out.println(prenotaBatteria.getId());
		
		if (ret.equals("ok")) {
			
			//ECCEZIONE->ROLLBACK TRANSAZIONE
			throw new RuntimeException("SIMULAZIONE DI ROLLBACK ULTIMA TRANSAZIONE");
		}

	    return prenotaBatteria;
	    
	}
	
	
	 
}
