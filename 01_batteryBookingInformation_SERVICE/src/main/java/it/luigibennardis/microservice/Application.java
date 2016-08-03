package it.luigibennardis.microservice;

 
import it.luigibennardis.microservice.mongodb.service.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    
    @Autowired
	private ApplicationContext context;
	
    
    @Bean
    CommandLineRunner initMOngoDB(){
                     	
    	MongoDbService  service = context.getBean(MongoDbService.class);
    	
   	 	service.initMongo();
    	
   	 	return null;
    	}
     	 
}





	    
		