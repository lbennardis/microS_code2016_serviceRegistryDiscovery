package it.luigibennardis.microservice.repositories;

import it.luigibennardis.microservice.domain.StationAddress;
import it.luigibennardis.microservice.domain.Users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//@RepositoryRestResource
public interface UtentiRepository extends JpaRepository<StationAddress, Long> {
	public List<StationAddress> findAll();

}
