package it.luigibennardis.microservice.clientdiscovery;

import it.luigibennardis.microservice.domain.Booking;
import java.net.URI;
import java.util.List;
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
@RestController
@EnableEurekaClient
public class EurekaClientDiscoveryApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientDiscoveryApplication.class, args);
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
				.path("/prenotazioni/lista").build().toUri(); 
		
		//***SHOW INSTACE CALLED BY LOAD BALANCING 
		System.out.println("instance uri -> " + instance.getUri().toString());
		
		Booking[] listBooking = restTemplate.getForObject(uri , Booking[].class);
		 
		return listBooking; 
		
	}
		
}


