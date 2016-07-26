package it.luigibennardis.microservice;

import java.util.List;

import it.luigibennardis.microservice.model.Booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void loggerSink(List <Booking> bookInfo) {
		
		
		 
		for (int i = 0; i < bookInfo.size(); i++) {
			Booking appo = bookInfo.get(i);
			
			System.out.println ("Received: " + appo.toString());
		}
		
		 
		
		
	}
		

}

