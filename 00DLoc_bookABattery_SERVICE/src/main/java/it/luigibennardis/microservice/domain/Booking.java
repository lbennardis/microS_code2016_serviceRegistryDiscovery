package it.luigibennardis.microservice.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DecimalFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "booking")
public class Booking {

	//@GeneratedValue
	@Id
    @JsonProperty("id")
	private String id ; //= UUID.randomUUID().toString();

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

    Booking() {
    }

    public Booking(String batteryCode, String stationId, String city, Double latitude, Double longitude) {
        this.id = UUID.randomUUID().toString();
    	this.batterycode = batteryCode;
        this.stationid = stationId;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
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

		 
	public String getLatitude() {
		
		//System.out.println("latitudine" + latitude);
		DecimalFormat myFormatter = new DecimalFormat("0000000.#####");
		String output = myFormatter.format(latitude);
		
		return output ;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getLongitudine() {
		
		//System.out.println("longitudine" + longitude);
		DecimalFormat myFormatter = new DecimalFormat("0000000.#####");
		String output = myFormatter.format(longitude);
		
		return output ;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}

 

