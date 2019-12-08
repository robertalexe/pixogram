package com.robert.fullstack.infra.followers;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.IdentitySupplier;
import com.robert.fullstack.domain.followers.Follower;
import com.robert.fullstack.domain.followers.Followers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static java.util.Objects.isNull;

@DDD.RepositoryImpl
@Service
public class SdjFollowers implements Followers {

    @Autowired
    private FollowersSdj followersSdj;
    @Autowired
    private IdentitySupplier identitySupplier;

    @Override
    public Set<Follower> getFollowers() {
        List<Follower> followers = followersSdj.findAllByFollowerEmail(identitySupplier.get().getUsername());
        return new HashSet<>(followers);
    }

    @Override
    public void addFollower(String email) {
        //TODO if exists already do nothing
        Follower newFollower = new Follower(UUID.randomUUID().toString(), identitySupplier.get().getUsername(), email);
        followersSdj.save(newFollower);
    }

    @Override
    public void removeFollower(String email) {
        Follower follower = followersSdj.findFollowerByFollowedEmailAndFollowerEmail(email, identitySupplier.get().getUsername());
        if(!isNull(follower)) {
            followersSdj.delete(follower);
            followersSdj.flush();
        }
    }
}
