package com.robert.fullstack.domain.followers;

import com.robert.fullstack.domain.ddd.BaseValueObject;
import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.user.Email;

import javax.validation.constraints.NotNull;
import java.util.List;

import static java.util.Arrays.asList;

@DDD.ValueObject
public class Subscriber extends BaseValueObject<Subscriber> {
    @NotNull
    private Email subscriberEmail;
    private boolean isSubscribed;

    public Subscriber(Email subscriberEmail, boolean isSubscribed) {
        super(Subscriber.class);
        this.subscriberEmail = subscriberEmail;
        this.isSubscribed = isSubscribed;
        validate(this);
    }

    public Email getSubscriberEmail() {
        return subscriberEmail;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return asList(subscriberEmail, isSubscribed);
    }

    /* Required by JPA. Do not use in production code! */
    protected Subscriber() {
        super(Subscriber.class);
    }
}
