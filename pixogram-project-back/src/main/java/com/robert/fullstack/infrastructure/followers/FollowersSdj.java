package com.robert.fullstack.infrastructure.followers;

import com.robert.fullstack.domain.followers.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowersSdj extends JpaRepository<Follower, String> {

    List<Follower> findAllByFollowerEmail(String followerEmail);

    Follower findFollowerByFollowedEmailAndFollowerEmail(String followedEmail, String followerEmail);
}
