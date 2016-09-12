package it.luigibennardis.microservice.repositories;

import it.luigibennardis.microservice.domain.StationAddress;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StazioniNamedQueryRepository extends Repository<StationAddress, Long> {
	// UTILIZZA LA NAMED QUERY A LIVELLO DI ENTITY CLASS
	
	 
	@Query 
	public List<StationAddress> findNearest(@Param(value = "latitude") Double latitude, 
		@Param(value = "longitude") Double longitude, @Param(value = "distance") Double distance );
	
	 
	}

 