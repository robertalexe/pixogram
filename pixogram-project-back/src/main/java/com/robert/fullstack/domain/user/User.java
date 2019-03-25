package com.robert.fullstack.domain.user;

import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.ImagePath;
import com.robert.fullstack.domain.pictures.Picture;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import static java.util.Objects.isNull;

@DDD.AggregateRoot
@Entity @Table(name = "APP_USERS")
@NoArgsConstructor @Getter @Setter
public class User {

    @Id @NotNull
    private String id;

    @Column
    private String password;

    @Embedded
    private ImagePath profilePicture;

    @Column(name = "REG_DATE")
    private LocalDateTime registrationDate;

    @Column(name = "REG_CODE")
    private String registrationCode;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ACTIVE")
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "UPLOADER_ID")
    private Set<Picture> pictures;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
        this.pictures = new HashSet<>();
    }

    public void addPicture(Picture picture) {
        if(isNull(this.pictures)) {
            this.pictures = new HashSet<>();
        }
        this.pictures.add(picture);
    }
}
