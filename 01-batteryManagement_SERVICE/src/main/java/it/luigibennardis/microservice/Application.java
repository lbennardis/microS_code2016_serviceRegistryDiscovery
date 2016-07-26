package it.luigibennardis.microservice;

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
	public void loggerSink(Booking bookInfo) {
		
		System.out.println ("Received: " + bookInfo.toString());
		//System.out.println ("Received meggage from timerTopic " );
		
	}
		

}

