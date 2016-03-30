package it.luigibennardis.microservice.repositories;

 

import it.luigibennardis.microservice.domain.Indirizzi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IndirizziRepository extends JpaRepository<Indirizzi,Long> {
	public List<Indirizzi> findAll();
}
