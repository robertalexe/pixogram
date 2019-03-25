package com.robert.fullstack.domain.pictures;

import com.robert.fullstack.domain.DDD;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@DDD.Entity
@Entity @Table(name = "USER_PICTURE_COMMENTS")
@NoArgsConstructor @Getter @Setter
public class PictureComment {

    @Id
    private String id;
    @Column(name = "PICTURE_ID")
    private String pictureId;
    @Column(name = "COMMENT")
    private String comment;
    @Column(name = "USER_ID")
    private String userEmail;
    @Column(name = "COMMENT_DATE")
    private LocalDateTime commentDate;
}
