package it.luigibennardis.microservice.domain;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="StationAddress.findNearest",query="SELECT stationid,address,city,latitude,longitude,3956 * 2 * (ASIN(SQRT(POWER(SIN((?1 - abs(latitude)) * pi()/180/2),2)+ COS(?1 * pi()/180 )*COS(abs(latitude) *  pi()/180)*POWER (SIN((?2 - longitude)) *  pi()/180/2, 2)))) AS distance FROM StationAddress WHERE (3956 * 2 * (ASIN(SQRT(POWER(SIN((?1 - abs(latitude)) * pi()/180/2),2)+ COS(?1 * pi()/180 )*COS(abs(latitude) *  pi()/180)*POWER (SIN((?2 - longitude)) *  pi()/180/2, 2))))) < ?3 ")
//@NamedQuery(name="StationAddress.findNearest",query="SELECT stationId,address,city,latitude,longitude FROM StationAddress")


public class StationAddress implements Serializable{ 
	
	private static final long serialVersionUID = 6075466029412276470L;
	
	
	@Id
	@Column(name="stationid")
	String stationid;
	@Column(name="address")
	String address;
	@Column(name="city")
	String city;
	@Column(name="latitude")
	Double latitude;
	@Column(name="longitude")
	Double longitude;
	
	//@Column(name="distanza",insertable = false, updatable = false)
    //long distanza; /*Virtual column for user responds*/ length = 25, 
	
	/*
	@Column(name = "distanza", insertable = false, updatable = false)
	Double distanza;
	
	public Double getDistanza() {
		return distanza;
	}
	*/		
	
	public String getStationId() {
		return stationid;
	}

	public void setStationId(String stationId) {
		this.stationid = stationId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLatitude() {
		//return latitudine;
		System.out.println("latitude" + latitude);
		DecimalFormat myFormatter = new DecimalFormat("###.########");
		String output = myFormatter.format(latitude);
		
		return output ;
		
		
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		//return longitude;
	
		System.out.println("longitude" + longitude);
		DecimalFormat myFormatter = new DecimalFormat("###.########");
		String output = myFormatter.format(longitude);
		
		return output ;
	}

	public void setLongitudine(Double longitude) {
		this.longitude = longitude;
	}

	
	
	public String toXML(){
		StringBuffer appo = new StringBuffer();
		
		appo.append("<StationId>" + this.getStationId()+"</StationId>");
		
		return appo.toString();
		
		
	}

			
}
