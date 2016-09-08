package it.luigibennardis.microservice.feignclient;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.luigibennardis.microservice.domain.Booking;


@SpringBootApplication
@EnableDiscoveryClient //REGISTER TO EUREKA
@RestController
@EnableFeignClients
public class EurekaFeignClientApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignClientApplication.class, args);
	}
	
	//***DECLARE THE INTERFACE TO THE SERVICE 
	@FeignClient("BOOKABATTERYSERVICE4EUREKA")
	interface IServiceBookAbattery {
				
		@RequestMapping(method = RequestMethod.GET, value = "/bookABattery/list")
		List<Booking> getBookingList();
				 
	} 
			
	@Autowired
	IServiceBookAbattery client;
	 	 
	@RequestMapping("/")
	public List<Booking> getBookingList() {
		return client.getBookingList();
	}
	 
	
}



