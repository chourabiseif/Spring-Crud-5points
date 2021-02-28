package com.fivepoints.demo.models;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

@Table(name ="profilePictures")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"createdAt", "updatedAt", "user"})
public class ProfilePicture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int id;

    @NonNull
    private String pictureName;

    @NonNull
    private String pictureType;

    @NonNull
    @Lob
    private byte[] data;

    //one to one relation
    @OneToOne(mappedBy ="profilePicture")
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
