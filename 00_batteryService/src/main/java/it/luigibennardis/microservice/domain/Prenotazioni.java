package it.luigibennardis.microservice.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DecimalFormat;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "prenotazioni")
public class Prenotazioni {

	//@GeneratedValue
	@Id
    @JsonProperty("id")
	private String id ; //= UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
    
    @JsonProperty("codice")
    private volatile String codice;

    @JsonProperty("stazione")
    private volatile String stazione;
    
    @JsonProperty("citta")
    private volatile String citta;

    @JsonProperty("latitudine")
    private long latitudine;

    @JsonProperty("longitudine")
    private long longitudine;

    Prenotazioni() {
    }

    public Prenotazioni(String codice, String stazione, String citta, long latitudine, long longitudine) {
        this.id = UUID.randomUUID().toString();
    	this.codice = codice;
        this.stazione = stazione;
        this.citta = citta;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
                }

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getStazione() {
		return stazione;
	}

	public void setStazione(String stazione) {
		this.stazione = stazione;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	/*public long getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(long latitudine) {
		this.latitudine = latitudine;
	}

	public long getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(long longitudine) {
		this.longitudine = longitudine;
	}*/

	 
	public String getLatitudine() {
		
		System.out.println("latitudine" + latitudine);
		DecimalFormat myFormatter = new DecimalFormat("0000000.#####");
		String output = myFormatter.format(latitudine);
		
		return output ;
	}

	public void setLatitudine(long latitudine) {
		this.latitudine = latitudine;
	}

	public String getLongitudine() {
		
		System.out.println("longitudine" + longitudine);
		DecimalFormat myFormatter = new DecimalFormat("0000000.#####");
		String output = myFormatter.format(longitudine);
		
		return output ;
	}

	public void setLongitudine(long longitudine) {
		this.longitudine = longitudine;
	}
}

 

