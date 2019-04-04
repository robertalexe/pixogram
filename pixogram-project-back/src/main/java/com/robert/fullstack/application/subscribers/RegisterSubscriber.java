package com.robert.fullstack.application.subscribers;

import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.followers.Followers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DDD.ApplicationService
@Service
@Transactional
public class RegisterSubscriber {

    @Autowired
    private Followers followers;

    public void addSubscriber(String subscriberEmail) {
        followers.addFollower(subscriberEmail);
    }
}
