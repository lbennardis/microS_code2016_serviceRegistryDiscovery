package it.luigibennardis.microservice.client;

//import it.luigibennardis.eureka.microservice.Anagrafica;
//import it.luigibennardis.eureka.microservice.AnagraficaRepository;

import java.util.Arrays;
import java.util.List;
 






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;







import com.netflix.appinfo.InstanceInfo;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
 
public class EurekaClientRibbonApplication {
	@Autowired
	HelloClient client;

	 
	@RequestMapping("/ciao")
	public String hello() {
		return  client.hello();
	}
	
	
	 
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
		SpringApplication.run(EurekaClientRibbonApplication.class, args);
	}

	private DiscoveryClient discoveryClient;
	
	 
	
	
	
    protected String getServiceAddress() {
        List<ServiceInstance> instances = this.discoveryClient.getInstances("microservice-server");
        if(instances != null && !instances.isEmpty()) {
            ServiceInstance serviceInstance = instances.get(0);
            return String.format("http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort());
        }
        throw new IllegalStateException("Unable to locate a microservice-server service");
    }
	
    
    
    
    @Bean
    CommandLineRunner init() {
    			System.out.println(" ");
           		System.out.println(this.getServiceAddress());
              	System.out.println(" ");
				return null;
              	}
    
    
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



