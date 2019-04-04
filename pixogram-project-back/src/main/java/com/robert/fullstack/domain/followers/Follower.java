package com.robert.fullstack.domain.followers;

import com.robert.fullstack.domain.DDD;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@DDD.Entity
@Entity @Table(name = "FOLLOWERS")
@NoArgsConstructor @Getter @Setter @AllArgsConstructor
public class Follower {

    @Id @NotNull
    private String id;
    @Column(name = "FOLLOWER_ID")
    private String followerEmail;
    @Column(name = "FOLLOWED_ID")
    private String followedEmail;

}
