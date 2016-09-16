package it.luigibennardis.microservice.web;

import it.luigibennardis.microservice.mongodb.repositories.IDetailedReservation;
import it.luigibennardis.microservice.mongodbentity.DetailedReservation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bookingInfoMaterializedView")
public class BatteryInformationController {
	@Autowired
	private final IDetailedReservation dtRepository;

	
    @Autowired
    BatteryInformationController(IDetailedReservation dtRepository) {
        this.dtRepository= dtRepository;
    }
			
	@RequestMapping(value = "/list")
	public List<DetailedReservation> listMaterializedReservation() {
				
		return dtRepository.findAll();
	}
	
	@RequestMapping(value = "/deleteForDemoOnly")
	public List<DetailedReservation> deleteMaterializedReservation() {
				
		dtRepository.deleteAll();
		return dtRepository.findAll();
		
	}
}
