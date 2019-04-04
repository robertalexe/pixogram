package com.robert.fullstack.application.subscribers;

import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.followers.Followers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DDD.ApplicationService
@Service
@Transactional
public class UnregisterSubscriber {

    @Autowired
    private Followers followers;

    public void deleteSubscriber(String subscriberEmail) {
        followers.removeFollower(subscriberEmail);
    }
}
