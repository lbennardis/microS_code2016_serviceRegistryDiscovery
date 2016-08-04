package it.luigibennardis.microservice.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class EurekaClientRibbonApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientRibbonApplication.class, args);
	}

	@Autowired
	DiscoveryClient discoveryClient;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	
	
	@RequestMapping("/discovery")
	public String discovery() {
		List<ServiceInstance> instances = this.discoveryClient.getInstances("BOOKABATTERYSERVICE4EUREKA");
	    if(instances != null && !instances.isEmpty()) {
	        ServiceInstance serviceInstance = instances.get(0);
	        return String.format("http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort());
	    }
		return "no instances of microservice-server";
			        
	}
		
	
	@RequestMapping("/loadBalancerClient")
	public String loadBalancerClient() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("BOOKABATTERYSERVICE4EUREKA");
        if (serviceInstance != null) {
            return String.format("http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort());
        } else {
        	return "no instances of load balancer client microservice-server";
        }
		
			        
	}
	
	
}



