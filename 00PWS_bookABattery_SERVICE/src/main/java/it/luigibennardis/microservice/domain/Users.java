package it.luigibennardis.microservice.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue
    private Long userid;

    public Long getUserId() {
        return userid;
    }
    @JsonProperty("firstname")
    private volatile String firstName;

    @JsonProperty("lastname")
    private volatile String lastName;

    Users() {
    }

    public Users(Long userId, String firstName, String lastName) {
        this.userid = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstNome() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}