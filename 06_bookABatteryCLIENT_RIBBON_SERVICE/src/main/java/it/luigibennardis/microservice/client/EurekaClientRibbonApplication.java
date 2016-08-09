package it.luigibennardis.microservice.client;

import it.luigibennardis.microservice.domain.Booking;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.UriBuilder;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
 
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
 
import org.springframework.context.annotation.Bean;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@SpringBootApplication
//@EnableDiscoveryClient
@RestController
//@EnableFeignClients
@EnableEurekaClient
public class EurekaClientRibbonApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientRibbonApplication.class, args);
	}

	@Autowired
	DiscoveryClient discoveryClient;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
			
	@RequestMapping("/listDiscovery")
	public String listDiscovery() {
       	List<ServiceInstance> instances = this.discoveryClient.getInstances("BOOKABATTERYSERVICE4EUREKA");
	    String appoRit = "instances->" + instances.size() + "<BR>"; 
       	if(instances != null && !instances.isEmpty()) {
	    	 for(int i=0; i<instances.size();i++ ){
	    		
	        	ServiceInstance serviceInstance = instances.get(i);
		        appoRit = appoRit + String.format(" http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort());
		        appoRit = appoRit + "<BR>";
	    	 }
	    	 return appoRit;
	    	    
	    	 
	    }
		return "NO INSTANCES OF BOOKABATTERYSERVICE4EUREKA";
			        
	}
		
	
	@RequestMapping("/loadBalancerClient")
	public String loadBalancerClient() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("BOOKABATTERYSERVICE4EUREKA");
        if (serviceInstance != null) {
            return String.format("http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort());
        } else {
        	return "NO INSTANCES OF LOAD BALANCING CLIENT BOOKABATTERYSERVICE4EUREKA";
        }
		
			        
	}
	
	 
	
	//LOAD BALANCER CLIENT "CLOUD.CLIENT.LOADBALANCER"
	@Autowired
	LoadBalancerClient loadBalancer;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	   RestTemplate restTemplate() {
	       return new RestTemplate();
	   }
	
	@RequestMapping("/loadBalancerBooking")
	public Booking[] getBooking(){
	
		
		ServiceInstance instance = this.loadBalancer.choose("BOOKABATTERYSERVICE4EUREKA");
		
		
		URI uri = UriComponentsBuilder.fromUriString(instance.getUri().toString())
				.path("/prenotazioni/lista").build().toUri(); 
				
		Booking[] listBooking = restTemplate.getForObject(uri , Booking[].class);
		 
		return listBooking; 
		
	}
	
	/*
	 * @RequestMapping(value = "/hello", method = RequestMethod.GET)
	    public String hello(@RequestParam(value="salutation",
	                                        defaultValue="Hello") String salutation,
	                        @RequestParam(value="name",
	                                        defaultValue="Bob") String name) {
	        URI uri = UriComponentsBuilder.fromUriString("http://message-generation/greeting")
	            .queryParam("salutation", salutation)
	            .queryParam("name", name)
	            .build()
	            .toUri();

	        Greeting greeting = rest.getForObject(uri, Greeting.class);
	        return greeting.getMessage();
	    }
	    */
	
	
}



