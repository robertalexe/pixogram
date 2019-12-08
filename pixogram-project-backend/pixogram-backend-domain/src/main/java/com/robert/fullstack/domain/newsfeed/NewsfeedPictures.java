package com.robert.fullstack.domain.newsfeed;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.followers.Follower;
import com.robert.fullstack.domain.followers.Followers;
import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.domain.pictures.Pictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@DDD.DomainService
@Service
public class NewsfeedPictures {

    @Autowired
    private Pictures pictures;
    @Autowired
    private Followers followers;

    public Set<Picture> findPictureIdsForNewsfeed() {
        Set<Follower> usersFollowed = followers.get();
        Set<Picture> pictureIds = new HashSet<>();
        usersFollowed.forEach( follower -> {
            pictureIds.addAll(pictures.getPicturesForUser(follower.getFollowedEmail(), true));
        });
        return pictureIds;
    }
}
