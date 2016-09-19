package it.luigibennardis.microservice.clientdiscovery.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import it.luigibennardis.microservice.domain.Booking;

@RestController
public class WebController {

	@Autowired
	DiscoveryClient discoveryClient;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
			
	@RequestMapping("/listDiscovery")
	public String listDiscovery() {
       	List<ServiceInstance> instances = this.discoveryClient.getInstances("BOOKABATTERYSERVICE4EUREKA");
	    String appoRit = "<h2><font color='blue'> Instances of 'BOOKABATTERYSERVICE4EUREKA' -> " + instances.size() + "</font></h2><BR>"; 
       	if(instances != null && !instances.isEmpty()) {
	    	 for(int i=0; i<instances.size();i++ ){
	    		
	        	ServiceInstance serviceInstance = instances.get(i);
		        appoRit = appoRit + "<h2><font color='blue'>" + String.format(" http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort());
		        appoRit = appoRit + "</font>" + "<BR>";
	    	 }
	    	 return appoRit;
	    	    
	    	 
	    }
		return "<h2><font color='red'>" + "Sorry... but there are no instances of <BR> BOOKABATTERYSERVICE4EUREKA" + "</font>";
			        
	}
		
	
	@RequestMapping("/loadBalancerClient")
	public String loadBalancerClient() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("BOOKABATTERYSERVICE4EUREKA");
        if (serviceInstance != null) {
            return String.format("http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort());
        } else {
        	return "NO INSTANCES OF LOAD BALANCING SERVICE:  BOOKABATTERYSERVICE4EUREKA";
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
				.path("/bookABattery/list").build().toUri(); 
		
		//***SHOW INSTACE CALLED BY LOAD BALANCING 
		System.out.println("");
		System.out.println("Instance uri -> " + instance.getUri().toString());
		System.out.println("");
		
		Booking[] listBooking = restTemplate.getForObject(uri , Booking[].class);
		 
		return listBooking; 
		
	}
		
}
