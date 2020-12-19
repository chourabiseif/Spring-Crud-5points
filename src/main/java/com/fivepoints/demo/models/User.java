package com.fivepoints.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@JsonProperty("id")
    private Long id;
    //nom dans base donnée pas le meme de l'attribut
    //@Column(name="First_name")
    //@JsonProperty("firstName")
    private String firstName;
    //@JsonProperty("lastName")
    private String lastName;
    //@JsonProperty("email")
    private String email;
    //@JsonProperty("password")
    private String password;
    //constructeurs
    @OneToMany
    private  List<Publication> publications;


    public User() {
        
        this.firstName ="";
        this.lastName ="";
        this.email ="";
        this.password ="";

    }

    public User(String firstName, String lastName, String email, String password) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    //getters
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    //setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
