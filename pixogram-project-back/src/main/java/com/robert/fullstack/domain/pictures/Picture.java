package com.robert.fullstack.domain.pictures;

import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.ImagePath;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@DDD.AggregateRoot
@Entity @Table(name = "USER_PICTURES")
@NoArgsConstructor @Getter @Setter @AllArgsConstructor
public class Picture {

    @Id
    private String pictureId;

    @Column(name = "OWNER_EMAIL")
    private String ownerEmail;

    @Embedded
    private ImagePath imagePath;

    @Column(name = "PICTURE_NAME")
    private String name;

    @Column(name = "ORIGINAL_NAME")
    private String originalName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SHARED_TO_FOLLOWERS")
    private boolean sharedToFollowers;

    @Column(name = "UPLOADED_DATE")
    private LocalDateTime uploadedDate;

    @ElementCollection
    @CollectionTable(name = "PICTURE_LIKED_BY", joinColumns = @JoinColumn(name = "OWNER_EMAIL"))
    @Column(name = "USER_EMAIL")
    private Set<String> likedBy;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PICTURE_ID")
    private Set<PictureComment> comments;

    public void addComment(PictureComment pictureComment) {
        comments.add(pictureComment);
    }

    public void addLike(String userEmail) {
        likedBy.add(userEmail);
    }

    public void removeLike(String userEmail) {
        likedBy.remove(userEmail);
    }
}
