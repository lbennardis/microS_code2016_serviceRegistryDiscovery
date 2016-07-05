package it.luigibennardis.microservice.domain;

public  class CreditCardInfo{

private String transactionId;
private String creditCardNumber;

public CreditCardInfo(String transactionId, String creditCardNumber){
	this.transactionId = transactionId;
	this.creditCardNumber = creditCardNumber;
}


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

