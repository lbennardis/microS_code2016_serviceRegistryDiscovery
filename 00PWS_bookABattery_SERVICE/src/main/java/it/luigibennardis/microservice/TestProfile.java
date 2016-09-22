package it.luigibennardis.microservice;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@Profile("cloudfoundry")
public class TestProfile {

	@Bean
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
	
}
