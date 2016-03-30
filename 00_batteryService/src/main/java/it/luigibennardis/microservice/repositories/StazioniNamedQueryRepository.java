package it.luigibennardis.microservice.repositories;

import it.luigibennardis.microservice.domain.Indirizzi;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StazioniNamedQueryRepository extends Repository<Indirizzi, Long> {
	// UTILIZZA LA NAMED QUERY A LIVELLO DI ENTITY CLASS
	@Query 
	public List<Indirizzi> findNearest(@Param(value = "latitudine") long latitudine, 
		@Param(value = "longitudine") long longitudine, @Param(value = "distanza") Double distanza );
	
	
	}
