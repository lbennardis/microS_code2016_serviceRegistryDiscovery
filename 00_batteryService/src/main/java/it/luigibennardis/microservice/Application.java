package it.luigibennardis.microservice;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.sql.DataSource;






import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@ComponentScan
@Configuration
@EnableAutoConfiguration
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
    
  //MANDA A CONSOLE UNA VERIFICA DELL'AMBIENTE 
    @Bean
    CommandLineRunner verifyEnv(
            DataSourceProperties dataSourceProps,
            @Value("${cloud.services.mySqlBackingServices.connection.jdbcurl:}") String jdbcUrl) 
    	{
        	return args -> System.out.println("\n\n JDBC URL=" + jdbcUrl + ".\n\n the DS URL=" + dataSourceProps.getUrl() + ".\n\n");
    	}
}

@RepositoryRestResource(collectionResourceRel = "batterie", path = "batterie")
interface IBatterie extends PagingAndSortingRepository<Batterie, String> {
	List<Batterie> findBystazione(@Param("stazione") String stazione);
}

@Entity
@Table(name = "batterie")
class Batterie {
	
	    
		@Id
		//@GeneratedValue
		@Column(name = "codice", unique = true, nullable = false)private String codice;
		    
		private String stazione;
		private String stato;

	    public Batterie() {
	    }

	    public Batterie(String codice, String stazione, String stato) {
	    	 this.codice = codice;
	    	 this.stazione = stazione;
	    	 this.stato = stato;
		        
	    }

		public String getCodice() {
			return codice;
		}

		public void setCodice(String codice) {
			this.codice = codice;
		}

		public String getStazione() {
			return stazione;
		}

		public void setStazione(String stazione) {
			this.stazione = stazione;
		}

		public String getStato() {
			return stato;
		}

		public void setStato(String stato) {
			this.stato = stato;
		}

	    
}


