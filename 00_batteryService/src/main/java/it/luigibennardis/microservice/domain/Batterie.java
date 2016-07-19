package it.luigibennardis.microservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "batterie")
public class Batterie {

	@Id
	//@GeneratedValue
	@Column(name = "codice", unique = true, nullable = false)private String codice;
	    
	private String stazione;
	private String stato;

    public Batterie() {
    }

    public Batterie(String codice, String stazione, String stato) {
    	 this.codice = codice;
    	 this.stazione = stazione;
    	 this.stato = stato;
	        
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

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

    
}


