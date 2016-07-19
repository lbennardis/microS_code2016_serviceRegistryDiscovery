package it.luigibennardis.microservice.repositories;

import it.luigibennardis.microservice.domain.Batterie;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "batterie", path = "batterie")
public interface IBatteryRepository extends PagingAndSortingRepository<Batterie, String> {
	List<Batterie> findBystazione(@Param("stazione") String stazione);
}



 