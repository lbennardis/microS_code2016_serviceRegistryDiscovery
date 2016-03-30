package it.luigibennardis.rest.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utenti {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    private String firstName, lastName;

    Utenti() {
    }

    public Utenti(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}