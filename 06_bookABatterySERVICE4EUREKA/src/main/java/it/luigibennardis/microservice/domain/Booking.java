package it.luigibennardis.microservice.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.springframework.data.jpa.repository.Query;

import java.text.DecimalFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "booking")
//ONLY ONE QUERY @NamedQuery(name="Booking.findPending",query="SELECT id,batterycode,stationid,city,latitude,longitude, bookingstate,tscreation, tsupdate FROM  Booking  WHERE bookingstate = 'PENDING' ")

@NamedQueries({
	@NamedQuery(name="Booking.findPending",
			query="SELECT id,batterycode,stationid,city,latitude,longitude, bookingstate,tscreation, tsupdate FROM  Booking  WHERE bookingstate = 'PENDING' "),
	@NamedQuery(name="Booking.updateBooking",
			query="UPDATE Booking  set bookingstate = 'CONFIRMED' WHERE id = ?1"),
	@NamedQuery(name="Booking.updateNotConfirmedBooking",
			query="UPDATE Booking  set bookingstate = 'NOT_CONFIRMED' WHERE id = ?1"),
	@NamedQuery(name="Booking.deleteExpiredBooking",
			query="UPDATE Booking  set bookingstate = 'EXPIRED' WHERE (TIMESTAMPDIFF(SECOND, tscreation, NOW() )>180 AND bookingstate='PENDING')")
	})


public class Booking {

	@Id
    @JsonProperty("id")
	private String id ;  

    public String getId() {
        return id;
    }
    
    @JsonProperty("batterycode")
    private volatile String batterycode;

    @JsonProperty("stationid")
    private volatile String stationid;
    
    @JsonProperty("city")
    private volatile String city;

    @JsonProperty("latitude")
    private Double latitude;

    @JsonProperty("longitude")
    private Double longitude;

    @JsonProperty("bookingstate")
    private volatile String bookingstate;
   
    @JsonProperty("tscreation")
    private volatile Date tscreation;
    
    @JsonProperty("tsupdate")
    private volatile Date tsupdate; 

   
    
    Booking() {
    }

    public Booking(String batteryCode, String stationId, String city, Double latitude, Double longitude, String bookingstate) {
        this.id = UUID.randomUUID().toString();
    	this.batterycode = batteryCode;
        this.stationid = stationId;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.bookingstate = bookingstate;
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        this.tscreation = timestamp;
        this.tsupdate = timestamp;
        
                }
    
    
	public String getBatterycode() {
		return batterycode;
	}
	
    
	
	public void setBatterycode(String batteryCode) {
		this.batterycode = batteryCode;
	}

	public String getStationid() {
		return stationid;
	}

	public void setStationid(String stationId) {
		this.stationid = stationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

		 
/*	public String getLatitude() {
		
		DecimalFormat myFormatter = new DecimalFormat("0000000.#####");
		String output = myFormatter.format(latitude);
		
		return output ;
	}*/
	public Double getLatitude() {
		
		 
		return latitude ;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

/*	public String getLongitudine() {
		
		DecimalFormat myFormatter = new DecimalFormat("0000000.#####");
		String output = myFormatter.format(longitude);
		
		return output ;
	}*/
	
	public Double getLongitude() {
		
		 
		return longitude ;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
		
	public String getBookingstate() {
		return bookingstate;
	}

	public void setBookingstate(String bookingstate) {
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
		
}

 

