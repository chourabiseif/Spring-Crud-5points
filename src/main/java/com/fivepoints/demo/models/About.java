package com.fivepoints.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
//Lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    // constructors code replaced with lombok annotations



    //getters and setters code replaced with lombok annotations


}
