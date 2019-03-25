package com.robert.fullstack.domain.user;

import com.robert.fullstack.domain.DDD;

@DDD.Repository
public interface Users {

    User findOne(String userName);
}
