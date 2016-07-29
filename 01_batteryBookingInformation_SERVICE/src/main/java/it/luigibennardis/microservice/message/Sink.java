package it.luigibennardis.microservice.message;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {
		 
		String INPUT_REQUEST = "confirmBookingTopic";

		@Input(Sink.INPUT_REQUEST)
		SubscribableChannel confirmBookingTopic();
		 
		
		
		/*
		String INPUT_CONFIRM = "confirmBookingTopic";

		@Input(Sink.INPUT_CONFIRM)
		SubscribableChannel confirmBookingTopic();
		
		IF NOT IMPLEMENTED THE CORRESPONDENT METHOD THEN AT THE WRITING ON THE TOPI THIS WILL CAUSE 
		
		KafkaMessage [Message(magic = 0, attributes = 0, crc = 2839187259, key = null, 
		payload = java.nio.HeapByteBuffer[pos=0 lim=2 cap=2]), KafkaMessageMetadata [offset=115369, nextOffset=115370, Partition[topic='confirmBookingTopic', id=0]]
		
		Dispatcher has no subscribers for channel '00-batteryService:localmysql:7111.confirmBookingTopic'.; 
		nested exception is org.springframework.integration.MessageDispatchingException: Dispatcher has no subscribers
		
		*/
	}