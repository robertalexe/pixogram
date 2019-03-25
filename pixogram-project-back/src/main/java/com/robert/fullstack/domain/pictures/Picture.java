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

@DDD.Entity
@Entity @Table(name = "USER_PICTURES")
@NoArgsConstructor @Getter @Setter @AllArgsConstructor
public class Picture {

    @Id
    private String id;

    @Column(name = "UPLOADER_ID")
    private String uploaderEmail;

    @Embedded
    private ImagePath imagePath;

    @Column(name = "PICTURE_NAME")
    private String name;

    @Column(name = "MIME_TYPE")
    private String mimeType;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SHARED_TO_FOLLOWERS")
    private boolean sharedToFollowers;

    @Column(name = "UPLOADED_DATE")
    private LocalDateTime uploadedDate;

    @Column(name = "NUMBER_OF_LIKES")
    private int numberOfLikes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PICTURE_ID")
    private Set<PictureComment> comments;
}
