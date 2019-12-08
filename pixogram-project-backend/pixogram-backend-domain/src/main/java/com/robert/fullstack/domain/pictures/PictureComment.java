package com.robert.fullstack.domain.pictures;

import com.robert.fullstack.domain.ddd.BaseEntity;
import com.robert.fullstack.domain.ddd.DDD;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@DDD.Entity
public class PictureComment extends BaseEntity<PictureComment, PictureCommentId> {
    @NotNull
    private PictureId pictureId;
    private Comment comment;
    private LocalDateTime commentDate;

    public PictureComment(PictureId pictureId, Comment comment, LocalDateTime commentDate) {
        super(PictureComment.class, new PictureCommentId());
        this.pictureId = pictureId;
        this.comment = comment;
        this.commentDate = commentDate;
        validate(this);
    }

    public PictureId getPictureId() {
        return pictureId;
    }

    public Comment getComment() {
        return comment;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    /* Required by JPA. Do not use in production code! */
    protected PictureComment() {
        super(PictureComment.class);
    }
}
