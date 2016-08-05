package it.luigibennardis.microservice.client;

import java.util.List;
 



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class HelloClientApplication {
	@Autowired
	HelloClient client;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	
	@RequestMapping("/ciao")
	public String hello() {
		return  client.hello() ;
				        
	}
 
	
	 
	@RequestMapping("/discovery")
	public String discovery() {
		List<ServiceInstance> instances = this.discoveryClient.getInstances("microservice-server");
	    if(instances != null && !instances.isEmpty()) {
	        ServiceInstance serviceInstance = instances.get(0);
	        return String.format("http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort());
	    }
		return "no instances of microservice-server";
			        
	}
		
		
	
	
	
	@RequestMapping("/loadBalancerClient")
	public String loadBalancerClient() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-server");
        if (serviceInstance != null) {
            return String.format("http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort());
        } else {
        	return "no instances of load balancer client microservice-server";
        }
		
			        
	}
	
    /*private final LoadBalancerClient loadBalancerClient;

    @Autowired
    public RibbonLeaderBoardApi(LoadBalancerClient loadBalancerClient) {
        this.loadBalancerClient = loadBalancerClient;
    }

    @Override
    protected String getLeaderBoardAddress() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("repmax-leaderboard");
        if (serviceInstance != null) {
            return String.format("http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort());
        } else {
            throw new IllegalStateException("Unable to locate a leaderboard service");
        }
    }
    */
	
	
	
	@RequestMapping("/")
	public String getGiocatore() {
		return client.getGiocatore("LUIGI").toString() + " - " +  client.hello();
	}
	
	
		
	//DEVE ESSERE DICHIARATO IL SERVIZIO COME REGISTRATO SU EUREKA
	@FeignClient("microservice-server")
	interface HelloClient {
		@RequestMapping(method = RequestMethod.GET, value = "/{userId}/giocatore")
		List<Anagrafica> getGiocatore(@PathVariable("userId") String userId);
		//@RequestMapping(value = "/", method = GET)
		@RequestMapping(method = RequestMethod.GET, value = "/")
		String hello();
	}

	
	public static void main(String[] args) {
		SpringApplication.run(HelloClientApplication.class, args);
	}

	
	/*
	protected String getServiceAddress() {
        List<ServiceInstance> instances = this.discoveryClient.getInstances("microservice-server");
        if(instances != null && !instances.isEmpty()) {
            ServiceInstance serviceInstance = instances.get(0);
            return String.format("http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort());
        }
        throw new IllegalStateException("Unable to locate a microservice-server service");
    }
	*/
   
}




class Anagrafica {
    private Long id;
    private String userId, cognome;

    @Override
    public String toString() {
        return "Anagrafica{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }

    public Anagrafica() {
    }

    public Long getId() {
        return id;
    }

     
    public String getCognome() {
        return cognome;
    }

    public String getUserId() {
        return userId;
    }
}



