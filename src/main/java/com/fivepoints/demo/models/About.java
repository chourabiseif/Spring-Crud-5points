package com.fivepoints.demo.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
//Lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"createdAt", "updatedAt", "user"})
public class About  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int id;

    @NonNull
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @NonNull
    private String country;

    @NonNull
    private String city;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String zipCode;

    // one to one relation
    @OneToOne(mappedBy="about")
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
