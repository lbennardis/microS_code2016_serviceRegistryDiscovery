package it.luigibennardis.microservice.mongodb.service;

 
import java.util.List;

 

import it.luigibennardis.microservice.mongodb.repositories.IDetailedReservation;
import it.luigibennardis.microservice.mongodbentity.DetailedReservation;
 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MongoDbService {
	
	@Autowired
	private final IDetailedReservation dtRepository;

	
    @Autowired
    MongoDbService(IDetailedReservation dtRepository) {
        this.dtRepository= dtRepository;
    }
    
    
    public void existRecord(String bookId ) {
    	
    	DetailedReservation dtRes = dtRepository.findByIdReservation(bookId);
    	
    	
    	//CHECK NULL OBJECT dtRes
    	// fetch all DetailedReservation
		System.out.println("DetailedReservation found: " + bookId);
		System.out.println("-------------------------------");
		//System.out.println(dtRes.toString());
		System.out.println("-------------------------------");
		
		
		DetailedReservation dtResupdate = new  DetailedReservation();
		
		dtResupdate.setIdReservation(dtRes.getIdReservation());
		dtResupdate.setIdTransaction("");
		dtResupdate.setState("REJECTED");
		 
		
		dtRepository.save(dtResupdate);
		
		System.out.println("DetailedReservation found with findAll():");
		System.out.println("-------------------------------");
		for (DetailedReservation dtList : dtRepository.findAll()) {
			System.out.println(dtList);
		}
		System.out.println();
		
    }
    
    
    public void initMongo() {
    	dtRepository.deleteAll();
    }
    
    
	public void insertDocument(String bookId) {

		

		dtRepository.save(new DetailedReservation(bookId, "", "PENDING"));
		
		// fetch all DetailedReservation
		System.out.println("AFTER INSERT DetailedReservation found with findAll():");
		System.out.println("-------------------------------");
		for (DetailedReservation dtRes : dtRepository.findAll()) {
			System.out.println(dtRes);
		}
		System.out.println("-------------------------------");
		
		System.out.println();

		 

	}


	public void updateConfirmRecord(String idReservation,
			String idFoundsReservation) {
		
		
		DetailedReservation dtRes = dtRepository.findByIdReservation(idReservation);
		
    	
    	//CHECK NULL OBJECT dtRes
    	// fetch all DetailedReservation
		System.out.println("DetailedReservation APPROVED found: " + idReservation);
		System.out.println("-------------------------------");
		System.out.println(dtRes.toString());
		System.out.println("-------------------------------");
		
		
		DetailedReservation dtResupdate = new  DetailedReservation();
		dtResupdate.setId(dtRes.getId());
		dtResupdate.setIdReservation(dtRes.getIdReservation());
		dtResupdate.setIdTransaction(idFoundsReservation);
		dtResupdate.setState("APPROVED");
		 
		
		dtRepository.save(dtResupdate);
		
		System.out.println("DetailedReservation APPROVED found with findAll():");
		System.out.println("-------------------------------");
		for (DetailedReservation dtList : dtRepository.findAll()) {
			System.out.println(dtList);
		}
		System.out.println("-------------------------------");
		System.out.println();
		
	}
}

