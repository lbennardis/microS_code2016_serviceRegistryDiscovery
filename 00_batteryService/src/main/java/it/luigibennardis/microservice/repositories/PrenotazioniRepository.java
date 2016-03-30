package it.luigibennardis.microservice.repositories;

 
import it.luigibennardis.microservice.domain.Prenotazioni;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, String> {

}
