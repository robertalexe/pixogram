package com.robert.fullstack.domain.followers;

import com.robert.fullstack.domain.ddd.BaseEntity;
import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.user.Email;

import javax.validation.constraints.NotNull;

@DDD.Entity
public class Follower extends BaseEntity<Follower, FollowerId> {

    @NotNull
    private Email followerEmail;
    @NotNull
    private Email followedEmail;

    public Follower(Email followerEmail, Email followedEmail) {
        super(Follower.class, new FollowerId());
        this.followerEmail = followerEmail;
        this.followedEmail = followedEmail;
        validate(this);
    }

    public Email getFollowerEmail() {
        return followerEmail;
    }

    public Email getFollowedEmail() {
        return followedEmail;
    }

    /* Required by JPA. Do not use in production code! */
    protected Follower() {
        super(Follower.class);
    }
}