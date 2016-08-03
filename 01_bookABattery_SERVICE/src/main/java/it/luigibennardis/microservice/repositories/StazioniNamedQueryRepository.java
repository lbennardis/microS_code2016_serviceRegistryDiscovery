package it.luigibennardis.microservice.repositories;

import it.luigibennardis.microservice.domain.StationAddress;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StazioniNamedQueryRepository extends Repository<StationAddress, Long> {
		 
	@Query 
	public List<StationAddress> findNearest(@Param(value = "latitude") long latitude, 
		@Param(value = "longitude") long longitude, @Param(value = "distance") Double distance );
	
	 
	}

 