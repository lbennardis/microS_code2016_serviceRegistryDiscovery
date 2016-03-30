package it.luigibennardis.rest.backingservices;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.luigibennardis.rest.data.UtentiRepository;
import it.luigibennardis.rest.data.Utenti;
import it.luigibennardis.rest.data.UtentiServiceImplementation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.sql.DataSource;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    @Profile("cloud")
    DataSource dataSource(@Value("${cloud.services.mySqlBackingServices.connection.jdbcurl}") String jdbcUrl) {
        try {
            return new SimpleDriverDataSource(                
            		com.mysql.jdbc.Driver.class.newInstance() , jdbcUrl);
        }
        //org.postgresql.Driver.class.newInstance() , jdbcUrl);
        catch (Exception e) {
        	
            throw new RuntimeException(e) ;
        }
    }

    @Bean
    @Profile("local")
    //CommandLineRunner seed(UtentiRepository utentiRepos) {
    CommandLineRunner caricaDb() {
    	
    	
    	
    	        return args -> {
        	System.out.println("profile local load data");
        	//utentiRepos.deleteAll();

            //Arrays.asList("Phil,Webb", "Josh,Long", "Dave,Syer", "Spencer,Gibb").stream()
        	//        .map(s -> s.split(","))
        	//        .forEach(namePair -> utentiRepos.save(new Utenti(namePair[0], namePair[1])));
			
        };
    }

    
    //MANDA A CONSOLE UNA VERIFICA DELL'AMBIENTE 
    @Bean
    CommandLineRunner verifyEnv(
            DataSourceProperties dataSourceProps,
            @Value("${cloud.services.mySqlBackingServices.connection.jdbcurl:}") String jdbcUrl) 
    	{
        	return args -> System.out.println("\n\n JDBC URL=" + jdbcUrl + ".\n\n the DS URL=" + dataSourceProps.getUrl() + ".\n\n");
    	}
}



