package it.luigibennardis.microservice.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "utenti")
public class Utenti {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
    @JsonProperty("nome")
    private volatile String nome;

    @JsonProperty("cognome")
    private volatile String cognome;

    Utenti() {
    }

    public Utenti(Long id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
}