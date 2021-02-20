package com.fivepoints.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@JsonProperty("id")
    private Long id;
    //nom dans base donnée pas le meme de l'attribut
    //@Column(name="First_name")
    //@JsonProperty("firstName")
    @NonNull
    private String firstName;
    //@JsonProperty("lastName")
    @NonNull
    private String lastName;
    //@JsonProperty("email")
    @NonNull
    private String email;
    @NonNull
    //@JsonProperty("password")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private  List<Publication> publications;

    @OneToOne
    private About about;
    @OneToOne
    private ProfilePicture profilePicture;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "roles_users",
            joinColumns = { @JoinColumn(name = "roles_id") },
            inverseJoinColumns = { @JoinColumn(name = "users_id") })
    private Set<Role> roles = new HashSet<>();


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
