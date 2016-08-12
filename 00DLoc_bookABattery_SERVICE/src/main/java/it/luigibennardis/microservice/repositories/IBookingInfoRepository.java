package it.luigibennardis.microservice.repositories;

 
import it.luigibennardis.microservice.domain.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingInfoRepository extends JpaRepository<Booking, String> {

}
