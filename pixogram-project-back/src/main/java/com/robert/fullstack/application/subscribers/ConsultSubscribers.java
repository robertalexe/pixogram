package com.robert.fullstack.application.subscribers;

import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.followers.AllSubscribers;
import com.robert.fullstack.domain.followers.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@DDD.ApplicationService
@Service
public class ConsultSubscribers {

    @Autowired
    private AllSubscribers allSubscribers;

    public Set<Subscriber> getAllSubscribers() {
        return allSubscribers.findAllPossibleSubscribers();
    }
}
