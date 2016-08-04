package it.luigibennardis.microservice.repositories;

import it.luigibennardis.microservice.domain.StationAddress;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtentiRepository extends JpaRepository<StationAddress, Long> {
	public List<StationAddress> findAll();

}
