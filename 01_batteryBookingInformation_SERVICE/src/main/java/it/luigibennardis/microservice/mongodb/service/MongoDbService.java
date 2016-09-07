package it.luigibennardis.microservice.mongodb.service;

import it.luigibennardis.microservice.mongodb.repositories.IDetailedReservation;
import it.luigibennardis.microservice.mongodbentity.DetailedReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoDbService {
	
	@Autowired
	private final IDetailedReservation dtRepository;

	
    @Autowired
    MongoDbService(IDetailedReservation dtRepository) {
        this.dtRepository= dtRepository;
    }
        
    public void updateNotConfirmedRecord(String bookId) {
    	
    	//***FIND DETAILED RESERVATION BY IDRESERVATION
    	DetailedReservation dtRes = dtRepository.findByIdReservation(bookId);
    	
    	//***PREPARE UPDATE RECORD 
		DetailedReservation dtResupdate = new  DetailedReservation();
		dtResupdate.setId(dtRes.getId());
		dtResupdate.setIdReservation(dtRes.getIdReservation());
		dtResupdate.setIdTransaction("");
		dtResupdate.setState("REJECTED");
		 
		//***SAVE UPDATED RECORD 
		dtRepository.save(dtResupdate);
		
		for (DetailedReservation dtList : dtRepository.findAll()) {
			//System.out.println(dtList);
		}
		
    }
    
    
    public void initMongo() {
    	//***INITIALIZE - ONLY FOR DEMO
		dtRepository.deleteAll();
    }
    
    
	public void insertDocument(String bookId) {

		//***SAVE A NEW DOCUMENT IN PENDING STATE (READED FROM PENDING TOPIC)
		dtRepository.save(new DetailedReservation(bookId, "", "PENDING"));
		
	}


	public void updateConfirmedRecord(String idReservation,
			String idFoundsReservation) {
		
		//***FIND DETAILED RESERVATION BY IDRESERVATION
    	DetailedReservation dtRes = dtRepository.findByIdReservation(idReservation);
				
		//***PREPARE UPDATE RECORD 
		DetailedReservation dtResupdate = new  DetailedReservation();
		dtResupdate.setId(dtRes.getId());
		dtResupdate.setIdReservation(dtRes.getIdReservation());
		dtResupdate.setIdTransaction(idFoundsReservation);
		dtResupdate.setState("APPROVED");
		 
		//***SAVE UPDATED RECORD 
		dtRepository.save(dtResupdate);
		
		for (DetailedReservation dtList : dtRepository.findAll()) {
			//System.out.println(dtList);
		}
		
	}
}

