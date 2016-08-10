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
		
		
		@RequestMapping(method = RequestMethod.GET, value = "/prenotazioni/lista")
		List<Booking> getBookingList();
		
		
		/*
		@RequestMapping(method = RequestMethod.GET, value = "/{userId}/user")
		List<Anagrafica> getDetailedBook(@PathVariable("userId") String userId);
		*/ 
		 
	} 
			
			
	@Autowired
	IServiceBookAbattery client;
	
	 
	@RequestMapping("/")
	public List<Booking> getGiocatore() {
		return client.getBookingList();
	}
	
	
}



