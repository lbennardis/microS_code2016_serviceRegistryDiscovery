package it.luigibennardis.microservice.domain;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Indirizzi.findNearest",query="SELECT nome,indirizzo,citta,latitudine,longitudine,3956 * 2 * (ASIN(SQRT(POWER(SIN((?1 - abs(latitudine)) * pi()/180/2),2)+ COS(?1 * pi()/180 )*COS(abs(latitudine) *  pi()/180)*POWER (SIN((?2 - longitudine)) *  pi()/180/2, 2)))) AS distanza FROM Indirizzi WHERE (3956 * 2 * (ASIN(SQRT(POWER(SIN((?1 - abs(latitudine)) * pi()/180/2),2)+ COS(?1 * pi()/180 )*COS(abs(latitudine) *  pi()/180)*POWER (SIN((?2 - longitudine)) *  pi()/180/2, 2))))) < ?3 ")
public class Indirizzi implements Serializable{ 
	
	private static final long serialVersionUID = 6075466029412276470L;
	
	
	@Id
	@Column(name="nome")
	String nome;
	@Column(name="indirizzo")
	String indirizzo;
	@Column(name="citta")
	String citta;
	@Column(name="latitudine")
	Double latitudine;
	@Column(name="longitudine")
	Double longitudine;
	
	//@Column(name="distanza",insertable = false, updatable = false)
    //long distanza; /*Virtual column for user responds*/ length = 25, 
	
	/*
	@Column(name = "distanza", insertable = false, updatable = false)
	Double distanza;
	
	public Double getDistanza() {
		return distanza;
	}
	*/		
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getLatitudine() {
		//return latitudine;
		System.out.println("latitudine" + latitudine);
		DecimalFormat myFormatter = new DecimalFormat("###.########");
		String output = myFormatter.format(latitudine);
		
		return output ;
		
		
	}

	public void setLatitudine(Double latitudine) {
		this.latitudine = latitudine;
	}

	public String getLongitudine() {
		//return longitudine;
	
		System.out.println("longitudine" + longitudine);
		DecimalFormat myFormatter = new DecimalFormat("###.########");
		String output = myFormatter.format(longitudine);
		
		return output ;
	}

	public void setLongitudine(Double longitudine) {
		this.longitudine = longitudine;
	}

	public String toXML(){
		StringBuffer appo = new StringBuffer();
		
		appo.append("<nome>" + this.getNome()+"<nome>");
		
		return appo.toString();
		
		
	}

			
}
