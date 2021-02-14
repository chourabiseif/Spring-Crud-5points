package com.fivepoints.demo.models;

import ch.qos.logback.classic.db.names.TableName;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

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

    // created at and updated at
    @Setter(value = AccessLevel.NONE)
    @Basic(optional = false)
    @CreationTimestamp
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @Setter(value = AccessLevel.NONE)
    @UpdateTimestamp
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt = new Date();

    // constructors code replaced with lombok annotations


    //getters and setters code replaced with lombok annotations


}
