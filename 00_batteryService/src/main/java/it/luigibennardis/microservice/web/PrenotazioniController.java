package it.luigibennardis.microservice.web;

import it.luigibennardis.microservice.domain.Prenotazioni;
import it.luigibennardis.microservice.repositories.IBookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/prenotazioni")
public class PrenotazioniController {
	@Autowired
	private final IBookRepository prenotazioniRepository;

    @Autowired
    PrenotazioniController(IBookRepository prenotazioniRepository) {
        this.prenotazioniRepository = prenotazioniRepository;
    }
        
	@RequestMapping(value = "/aggiungi/{stazione}/{batteria}/{citta}/{latitudine}/{longitudine}")
	public Prenotazioni addBook(@PathVariable String stazione, @PathVariable String batteria,
			 @PathVariable String citta , @PathVariable long latitudine, @PathVariable long longitudine) {
		
		Prenotazioni prenotaBatteria = new Prenotazioni(stazione + batteria,stazione,citta,latitudine,longitudine);
		
		prenotazioniRepository.saveAndFlush(prenotaBatteria);
			
	    return prenotaBatteria;
	    
	}
			
	@RequestMapping(value = "/lista")
	public List<Prenotazioni> listaPrenotazioni() {
				
		return prenotazioniRepository.findAll();
	}
		
}
