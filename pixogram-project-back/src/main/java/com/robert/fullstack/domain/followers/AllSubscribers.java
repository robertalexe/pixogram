package com.robert.fullstack.domain.followers;

import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.IdentitySupplier;
import com.robert.fullstack.domain.user.User;
import com.robert.fullstack.domain.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@DDD.DomainService
@Service
public class AllSubscribers {

    @Autowired
    private IdentitySupplier identitySupplier;
    @Autowired
    private Followers followers;
    @Autowired
    private Users users;

    public Set<Subscriber> findAllPossibleSubscribers() {
        Set<Subscriber> allSubscribers = new HashSet<>();

        Set<Follower> allFollowers = followers.findFollowersForCurrentUser();
        allFollowers.forEach( follower -> allSubscribers.add(new Subscriber(follower.getFollowedEmail(), true)));

        List<String> allFollowersNames = allFollowers.stream().map(Follower::getFollowedEmail).collect(Collectors.toList());

        List<User> allUsers = users.getAllUsers();
        List<User> usersNotFollowed = allUsers.stream().filter( user -> !allFollowersNames.contains(user.getEmail())).collect(Collectors.toList());

        usersNotFollowed.forEach( user -> allSubscribers.add(new Subscriber(user.getEmail(), false)));

        return allSubscribers;

    }
}
