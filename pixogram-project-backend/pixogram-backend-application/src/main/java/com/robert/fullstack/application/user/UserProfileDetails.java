package com.robert.fullstack.application.user;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.IdentitySupplier;
import com.robert.fullstack.domain.user.User;
import com.robert.fullstack.domain.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DDD.ApplicationService
@Service
public class UserProfileDetails {

    @Autowired
    private IdentitySupplier identitySupplier;

    @Autowired
    private Users users;

    public User getUserProfileDetails() {
        return users.findOne(identitySupplier.get().getUsername());
    }
}
