package it.luigibennardis.microservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "batteryinventory")
public class BatteryInventory<batterycode> {

	
	@Id
	//@GeneratedValue
	@Column(name = "batterycode", unique = true, nullable = false)private String batterycode;
	    
	private String stationid;
	private String batterystatus;

    public BatteryInventory() {
    }

    public BatteryInventory(String batteryCode, String stationId, String batteryStatus) {
    	 this.batterycode = batteryCode;
    	 this.stationid = stationId;
    	 this.batterystatus = batteryStatus;
	        
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

	public String getBatteryStatus() {
		return batterystatus;
	}

	public void setBatteryStatus(String batteryStatus) {
		this.batterystatus = batteryStatus;
	}

    
}


