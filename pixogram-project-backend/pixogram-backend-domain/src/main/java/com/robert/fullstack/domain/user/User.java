package com.robert.fullstack.domain.user;

import com.robert.fullstack.domain.ddd.BaseAggregateRoot;
import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.pictures.PictureId;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@DDD.AggregateRoot
public class User extends BaseAggregateRoot<User, Email> {
    @NotNull
    private Password password;
    @NotNull
    private UserDetails userDetails;
    private PictureId profilePictureId;
    @NotNull
    private LocalDateTime registrationDate;
    private boolean active;

    public User(Email email, Password password, PictureId profilePictureId, LocalDateTime registrationDate, UserDetails userDetails, boolean active) {
        super(User.class, email);
        this.password = password;
        this.profilePictureId = profilePictureId;
        this.registrationDate = registrationDate;
        this.userDetails = userDetails;
        this.active = active;
        validate(this);
    }

    public Password getPassword() {
        return password;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public PictureId getProfilePictureId() {
        return profilePictureId;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public boolean isActive() {
        return active;
    }

    /* Required by JPA. Do not use in production code! */
    protected User() {
        super(User.class);
    }
}
