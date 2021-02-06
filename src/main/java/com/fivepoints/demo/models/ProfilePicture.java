package com.fivepoints.demo.models;

import ch.qos.logback.classic.db.names.TableName;
import lombok.*;

import javax.persistence.*;

@Entity

@Table(name ="profilePictures")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class ProfilePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NonNull
    private String pictureName;
    @NonNull
    private String pictureType;
    @NonNull
    @Lob
    private byte[] data;
    @OneToOne
    private User user;

    // constructors code replaced with lombok annotations


    //getters and setters code replaced with lombok annotations


}
