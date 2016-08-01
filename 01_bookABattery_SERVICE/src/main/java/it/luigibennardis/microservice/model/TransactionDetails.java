package it.luigibennardis.microservice.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDetails {
	
	@JsonProperty("idReservation")
	private String idReservation;
	
	@JsonProperty("idFoundsReservation")
	private String idFoundsReservation;
	
	@JsonProperty("tsFoundsReservation")
    private volatile Date tsFoundsReservation;
	
    public TransactionDetails(String idReservation, String idFoundsReservation, Date tsFoundsReservation){
        this.idReservation = idReservation;  
    	this.idFoundsReservation = idFoundsReservation;
    	this.tsFoundsReservation = tsFoundsReservation; 
        }
    
    public String getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(String idReservation) {
		this.idReservation = idReservation;
	}
	public String getIdFoundsReservation() {
		return idFoundsReservation;
	}
	public void setIdFoundsReservation(String idFoundsReservation) {
		this.idFoundsReservation = idFoundsReservation;
	}
	
	public Date getTsFoundsReservation() {
		return tsFoundsReservation;
	}
	
	public void setTsFoundsReservation(Date  tsFoundsReservation) {
		this.tsFoundsReservation = tsFoundsReservation;
	}	
    
    
    
}
