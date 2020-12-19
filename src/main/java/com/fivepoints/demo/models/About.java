package com.fivepoints.demo.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class About  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String birthdate;
    private String country;
    private String city;
    private String phoneNumber;
    private String zipCode;
    @OneToOne
    private User user;

    // constructors


    public About(String birthdate, String country, String city, String phoneNumber, String zipCode, User user) {
        this.birthdate = birthdate;
        this.country = country;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.user = user;
    }

    public About() {

    }
    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
