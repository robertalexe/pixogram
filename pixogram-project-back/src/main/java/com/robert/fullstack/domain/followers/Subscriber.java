package com.robert.fullstack.domain.followers;

import com.robert.fullstack.domain.DDD;
import lombok.AllArgsConstructor;
import lombok.Getter;

@DDD.ValueObject @Getter @AllArgsConstructor
public class Subscriber {

    private String subscriberEmail;
    private boolean isSubscribed;

}
