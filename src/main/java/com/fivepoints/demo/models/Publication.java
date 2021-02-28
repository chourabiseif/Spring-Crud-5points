package com.fivepoints.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"createdAt", "updatedAt", "user"})
@Table(name="publications")
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int id;

    @NonNull
    private String title;

    @NonNull
    @Lob
    private String description;

    @NonNull
    @Column(name = "published")
    private boolean published;

    // OneToMany Relations
    @ManyToOne
    @JoinColumn(name="user_id", nullable=true)
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
