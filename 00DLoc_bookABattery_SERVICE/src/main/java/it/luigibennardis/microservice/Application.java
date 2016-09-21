package it.luigibennardis.microservice;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
     
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
   
    @Bean
    CommandLineRunner verifyEnv(
            DataSourceProperties dataSourceProps,
            @Value("${cloud.services.mySqlBackingServices.connection.jdbcurl:}") String jdbcUrl) 
    	{
        	return args -> System.out.println("cloud.services.mySqlBackingServices.connection.jdbcurl \n\n JDBC URL=" + jdbcUrl + ".\n\n the DS URL=" + dataSourceProps.getUrl() + ".\n\n");
    	}
     	 
}





	    
		