package com.robert.fullstack.domain.followers;

import com.robert.fullstack.domain.DDD;

import java.util.Set;

@DDD.Repository
public interface Followers {

    Set<Follower> findFollowersForCurrentUser();

    void addFollower(String email);

    void removeFollower(String email);
}
