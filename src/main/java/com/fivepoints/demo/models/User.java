package com.fivepoints.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    //private byte profilePicture;

    @OneToMany
    private  List<Publication> publications;
    @OneToOne
    private About about;
    @OneToOne
    private ProfilePicture profilePicture;

    // constructors code replaced with lombok annotations



    //getters and setters code replaced with lombok annotations






}
