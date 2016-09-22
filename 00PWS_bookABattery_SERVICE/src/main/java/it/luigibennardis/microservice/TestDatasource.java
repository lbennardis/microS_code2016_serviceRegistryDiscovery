package it.luigibennardis.microservice;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;

@Component
public class TestDatasource implements ApplicationRunner{

	

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		
		 
		System.out.println("passing here");
		
		/*
		 * 
		 * DataSourceProperties dataSourceProps = new DataSourceProperties();
		
	    
		System.out.println("passing here");
		
		System.out.println(dataSourceProps.getUrl());
		
		dataSourceProps = @Value("${cloud.services.mySqlBackingServices.connection.jdbcurl:}") 
		
		String jdbcUrl); 
	{
    	return args -> 
    	System.out.println("\n\n  cloud.services.mySqlBackingServices.connection.jdbcurl JDBC URL=" + jdbcUrl 
    	+ " \n\n the DATASOURCE URL=" + dataSourceProps.getUrl() + ".\n\n");
	 
		*/
	}
	
}
