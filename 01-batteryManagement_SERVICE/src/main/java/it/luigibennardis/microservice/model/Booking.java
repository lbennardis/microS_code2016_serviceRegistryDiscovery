package it.luigibennardis.microservice.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.text.DecimalFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Booking {

	@Id
	@JsonProperty("id")
	private String id ;  

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id =id;
    }
    
    @JsonProperty("batterycode")
    private volatile String batterycode;

    @JsonProperty("stationid")
    private volatile String stationid;
    
    @JsonProperty("city")
    private volatile String city;

    @JsonProperty("latitude")
    private long latitude;

    @JsonProperty("longitude")
    private long longitude;

    @JsonProperty("bookingstate")
    private volatile String bookingstate;
   
    @JsonProperty("tscreation")
    private volatile Date tscreation;
    
    @JsonProperty("tsupdate")
    private volatile Date tsupdate; 
    
    Booking() {
    }

     
        
    public Booking(String id, String batteryCode, String stationId, String city, long latitude, long longitude, String bookingstate, Date tscreation, Date tsupdate) {
        this.id = id ; //UUID.randomUUID().toString();
    	this.batterycode = batteryCode;
        this.stationid = stationId;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tscreation = tscreation;
        this.tsupdate = tsupdate;
        }
    
    
	public String getBatteryCode() {
		return batterycode;
	}
	    
	
	public void setBatteryCode(String batteryCode) {
		this.batterycode = batteryCode;
	}

	public String getStationId() {
		return stationid;
	}

	public void setStationId(String stationId) {
		this.stationid = stationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

		 
	public String getLatitude() {
		
		//System.out.println("latitudine" + latitude);
		DecimalFormat myFormatter = new DecimalFormat("0000000.#####");
		String output = myFormatter.format(latitude);
		
		return output ;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public String getLongitudine() {
		
		//System.out.println("longitudine" + longitude);
		DecimalFormat myFormatter = new DecimalFormat("0000000.#####");
		String output = myFormatter.format(longitude);
		
		return output ;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	
	public String getBookingState() {
		return bookingstate;
	}

	public void setBookingState(String bookingstate) {
		this.bookingstate = bookingstate;
	}
	
	public Date getTscreation() {
		return tscreation;
	}
	
	public void SetTscreation(Date  tscreation) {
		this.tscreation = tscreation;
	}
	
	public Date getTsupdate() {
		return tsupdate;
	}
	
	public void SetTsupdate(Date  tsupdate) {
		this.tsupdate = tsupdate;
	}	
	
	@Override
	public String toString() {
		return "booking INFO  [trabsaction id=" + this.getId() + ", batterycode=" + this.getBatteryCode() + "]";
	}
	public String toXML() {
		return "<trabsaction id=" + this.getId() + "><batterycode=" + this.getBatteryCode() + ">";
	}
	
}

 

