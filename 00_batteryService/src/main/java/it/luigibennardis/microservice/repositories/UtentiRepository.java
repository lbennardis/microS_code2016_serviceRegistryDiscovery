package it.luigibennardis.microservice.repositories;

import it.luigibennardis.microservice.domain.Indirizzi;
import it.luigibennardis.microservice.domain.Utenti;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//@RepositoryRestResource
public interface UtentiRepository extends JpaRepository<Indirizzi, Long> {
	public List<Indirizzi> findAll();

}
