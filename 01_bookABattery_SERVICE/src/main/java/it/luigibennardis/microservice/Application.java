package it.luigibennardis.microservice;

import it.luigibennardis.microservice.repositories.IBookingInfoRepository;

import javax.sql.DataSource;






import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
 
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;


//@EnableDiscoveryClient //***AGGIUNTO PER EUREKA
@SpringBootApplication
//@EnableBinding(Source.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
       
    /*
    @Bean
	@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
	public MessageSource<TimeInfo> timerMessageSource() {
		
    	// CALL SERVICE THAT RETURNS A LIST OF BOOKING RECORD IN PENDING STATE 
    	
    	
    	
        
    	TimeInfo timeInfo = new TimeInfo(new Date().getTime()+"","Label");
    	
    	
    	
    	return () -> MessageBuilder.withPayload(timeInfo).build();
    	}
	
	public static class TimeInfo{
		
		private String time;
		private String label;
		
		public TimeInfo(String time, String label) {
			super();
			this.time = time;
			this.label = label;
		}

		public String getTime() {
			return time;
		}

		public String getLabel() {
			return label;
		}
		
	}
	
	
	
	 */
    
    
    
    /*
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    */
     
    @Bean
    @Profile("cloudfoundry")
    DataSource dataSource(@Value("${cloud.services.mySqlBackingServices.connection.jdbcurl}") String jdbcUrl) {
    	System.out.println("\n\n Bean PROFILE CLOUD FOUNDRY");
    	
    	try {
            return new SimpleDriverDataSource(
            	com.mysql.jdbc.Driver.class.newInstance() , jdbcUrl);
        }
        catch (Exception e) {
            throw new RuntimeException(e) ;
        }
    }
    
    /* classe di utilità per caricare il db H2 che con atomiko non funziona  flyway-core  
    @Bean
    @Profile("localh2")
    CommandLineRunner commandLineRunner(DatabaseInitializer databaseInitializer) {
        return args -> {
            // Initialize the database for end to end integration testing
            databaseInitializer.populate();
        };
    }*/
      
    
  //MANDA A CONSOLE UNA VERIFICA DELL'AMBIENTE 
     
    
    @Bean
    CommandLineRunner verifyEnv(
            DataSourceProperties dataSourceProps,
            @Value("${cloud.services.mySqlBackingServices.connection.jdbcurl:}") String jdbcUrl) 
    	{
        	return args -> System.out.println("cloud.services.mySqlBackingServices.connection.jdbcurl \n\n JDBC URL=" + jdbcUrl + ".\n\n the DS URL=" + dataSourceProps.getUrl() + ".\n\n");
    	}
     	 
}





	    
		