package it.luigibennardis.rest.web;

import it.luigibennardis.rest.data.Utenti;
import it.luigibennardis.rest.data.UtentiServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/utenti")
public class UtentiController {
	@Autowired
	private UtentiServiceImplementation usrService;

	@RequestMapping(value = "/")
	public List<Utenti> getUtenti() {
		return usrService.findAll();
	}
	
}