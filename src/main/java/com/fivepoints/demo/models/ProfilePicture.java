package com.fivepoints.demo.models;

import ch.qos.logback.classic.db.names.TableName;

import javax.persistence.*;

@Entity
@Table(name ="profilePictures")
public class ProfilePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String pictureName;
    private String pictureType;
    @Lob
    private byte[] data;
    @OneToOne
    private User user;

    //constructeurs

    public ProfilePicture() {
    }

    public ProfilePicture(String pictureName, String pictureType, byte[] data) {
        this.pictureName = pictureName;
        this.pictureType = pictureType;
        this.data = data;
    }
    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
