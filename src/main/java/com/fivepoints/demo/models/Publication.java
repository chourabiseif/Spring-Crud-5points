package com.fivepoints.demo.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="publications")
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    @ManyToOne
    private User user;

    // constructeurs

    public Publication() {
        this.title="";
        this.description="";
    }

    public Publication(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Publication(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }
    // Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
