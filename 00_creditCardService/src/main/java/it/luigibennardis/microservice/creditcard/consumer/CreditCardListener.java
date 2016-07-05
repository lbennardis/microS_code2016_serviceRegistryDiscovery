package it.luigibennardis.microservice.creditcard.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class CreditCardListener {


	public static void main(String[] args) {
		SpringApplication.run(CreditCardListener.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void loggerSink(CreditCardInfo creditCardInfo) {
		
		System.out.println ("Received: " + creditCardInfo.toString());
		
	}
	
	public static class CreditCardInfo{
		
		private String transactionId;
		private String creditCardNumber;
		
	

		public String getTransactionId() {
			return transactionId;
		}



		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}



		public String getCreditCardNumber() {
			return creditCardNumber;
		}



		public void setCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
		}



		@Override
		public String toString() {
			return "CreditCardInfo [transaction id=" + transactionId + ", Credit Card Number=" + creditCardNumber + "]";
		}
		
	}


}

