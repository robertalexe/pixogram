package com.robert.fullstack.exposition.subscribers;

import com.robert.fullstack.domain.followers.Subscriber;

public class SubscribedRepresentation {

    public String email;
    public boolean isSubscribed;

    public SubscribedRepresentation(Subscriber subscriber) {
        this.email = subscriber.getSubscriberEmail();
        this.isSubscribed = subscriber.isSubscribed();
    }
}
