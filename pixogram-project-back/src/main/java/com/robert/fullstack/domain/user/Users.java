package com.robert.fullstack.domain.user;

import com.robert.fullstack.domain.DDD;

import java.util.List;

@DDD.Repository
public interface Users {

    User findOne(String userName);

    List<User> getAllUsers();
}
