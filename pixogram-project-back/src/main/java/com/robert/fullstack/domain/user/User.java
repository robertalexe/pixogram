package com.robert.fullstack.domain.user;

import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.ImagePath;
import com.robert.fullstack.domain.pictures.Picture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.isNull;

@DDD.AggregateRoot
@Entity @Table(name = "APP_USERS")
@NoArgsConstructor @Getter @Setter
@AllArgsConstructor
public class User {

    @Id @NotNull
    private String email;

    @Column
    private String password;

    @Column(name = "PROFILE_PICTURE_ID")
    private String profilePictureId;

    @Column(name = "REG_DATE")
    private LocalDateTime registrationDate;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ACTIVE")
    private boolean active;

}
