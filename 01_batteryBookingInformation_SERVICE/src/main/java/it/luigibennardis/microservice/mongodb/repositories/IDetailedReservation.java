package it.luigibennardis.microservice.mongodb.repositories;

import it.luigibennardis.microservice.mongodbentity.DetailedReservation;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDetailedReservation extends MongoRepository<DetailedReservation, String> {

	public DetailedReservation findById(String id);
	public DetailedReservation findByIdReservation(String idReservation);
    public List<DetailedReservation> findByIdTransaction(String idTransaction);
    public List<DetailedReservation> findAll();

}


 