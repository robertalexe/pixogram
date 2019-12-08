package com.robert.fullstack.exposition.user;

import com.robert.fullstack.domain.user.User;

import static com.robert.fullstack.exposition.LocalDateTimeAdapter.dateTimeToStringFormatter;

public class UserProfileDetailsRepresentation {

    public String email;
    public String profilePictureId;
    public String registrationDate;
    public String firstName;
    public String lastName;

    public UserProfileDetailsRepresentation(User user) {
        this.email = user.getEmail();
        this.profilePictureId = user.getProfilePictureId();
        this.registrationDate = dateTimeToStringFormatter(user.getRegistrationDate());
        this.lastName = user.getLastName();
        this.firstName = user.getFirstName();
    }
}
