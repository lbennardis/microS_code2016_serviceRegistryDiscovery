package it.luigibennardis.microservice.web;



 
import it.luigibennardis.microservice.domain.Indirizzi;
import it.luigibennardis.microservice.domain.Match;
import it.luigibennardis.microservice.domain.Prenotazioni;
import it.luigibennardis.microservice.domain.Utenti;
import it.luigibennardis.microservice.repositories.IndirizziRepository;
import it.luigibennardis.microservice.repositories.MatchRepository;
import it.luigibennardis.microservice.repositories.PrenotazioniRepository;
import it.luigibennardis.microservice.repositories.ResultRepository;
import it.luigibennardis.microservice.repositories.StazioniNamedQueryRepository;
import it.luigibennardis.microservice.repositories.UtentiRepository;

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
public class UtentiController {

	
	private final StazioniNamedQueryRepository stazioniRepository;
	private final IndirizziRepository indirizziRepository;
	
    @Autowired
    UtentiController(StazioniNamedQueryRepository stazioniRepository, IndirizziRepository indirizziRepository ) {
    	this.stazioniRepository = stazioniRepository;
    	this.indirizziRepository = indirizziRepository;
        
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/indirizzi")
    ResponseEntity<List<Indirizzi>> listaIndirizzi() {
        
    	List<Indirizzi> indirizzi = indirizziRepository.findAll();
    	
    	
    	
    	return new ResponseEntity<>(indirizzi, HttpStatus.OK);
    	//return null;
    	//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/trovaStazionePiuVicina/{latitudine}/{longitudine}/{distanza}")
    ResponseEntity<List<Indirizzi>> trovaStazionepiuVicina(@PathVariable long latitudine,
    		@PathVariable long longitudine, long distanza) {
        
    	List<Indirizzi> indirizzi = stazioniRepository.findNearest(latitudine,longitudine,Double.valueOf(distanza));
    	
    	//return new ResponseEntity<>(result, HttpStatus.CREATED);
        
        
    	
    	return new ResponseEntity<>(indirizzi, HttpStatus.OK);
    	
    	//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
   
}