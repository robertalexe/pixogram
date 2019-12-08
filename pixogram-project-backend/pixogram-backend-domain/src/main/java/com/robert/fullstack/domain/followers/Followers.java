package com.robert.fullstack.domain.followers;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.user.Email;

import java.util.Set;

@DDD.Repository
public interface Followers {

    Set<Follower> get();

    Follower add(Email email);

    void remove(Email email);
}
