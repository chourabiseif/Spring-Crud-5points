package com.fivepoints.demo.playLoad.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


//Lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {

    private String to;
    private  String body;
    private  String topic;
}
