package it.luigibennardis.microservice.repositories;


import it.luigibennardis.microservice.domain.Booking;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;


public interface IBookingNamedQueryRepository extends Repository<Booking, Long> {
	// UTILIZZA LA NAMED QUERY A LIVELLO DI ENTITY CLASS
	
	 
	@Query 
	public List<Booking> findPending();
	
	@Query
	@Modifying
	@Transactional
	void updateBooking(@Param(value = "id") String id);
		
	
	@Query
	@Modifying
	@Transactional
	void updateNotConfirmedBooking(@Param(value = "id") String id);
		
	
	@Query
	@Modifying
	@Transactional
	void deleteExpiredBooking();
	
}