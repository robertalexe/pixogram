package com.robert.fullstack.domain.pictures;

import com.robert.fullstack.domain.ddd.BaseAggregateRoot;
import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.user.Email;
import com.robert.fullstack.domain.user.NameFragment;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@DDD.AggregateRoot
public class Picture extends BaseAggregateRoot<Picture, PictureId> {
    @NotNull
    private Email ownerEmail;
    @NotNull
    private ImagePath imagePath;
    private PictureInfo pictureInfo;
    private boolean sharedToFollowers;
    private LocalDateTime uploadedDate;
    private Set<Email> likedBy;
    private Set<PictureComment> comments;

    public Picture(PictureId id, Email ownerEmail, ImagePath imagePath, PictureInfo pictureInfo, boolean sharedToFollowers, LocalDateTime uploadedDate, Set<Email> likedBy, Set<PictureComment> comments) {
        super(Picture.class, id);
        this.ownerEmail = ownerEmail;
        this.imagePath = imagePath;
        this.pictureInfo = pictureInfo;
        this.sharedToFollowers = sharedToFollowers;
        this.uploadedDate = uploadedDate;
        this.likedBy = new HashSet<>(likedBy);
        this.comments = new HashSet<>(comments);
        validate(this);
    }

    public Email getOwnerEmail() {
        return ownerEmail;
    }

    public ImagePath getImagePath() {
        return imagePath;
    }

    public PictureInfo getPictureInfo() {
        return pictureInfo;
    }

    public boolean isSharedToFollowers() {
        return sharedToFollowers;
    }

    public LocalDateTime getUploadedDate() {
        return uploadedDate;
    }

    public Set<Email> getLikedBy() {
        return likedBy;
    }

    public Set<PictureComment> getComments() {
        return comments;
    }

    public void rename(NameFragment newName) {
        //TODO implement
    }

    public void addComment(PictureComment pictureComment) {
        comments.add(pictureComment);
        validate(this);
    }

    public void addLike(Email userEmail) {
        likedBy.add(userEmail);
        validate(this);
    }

    public void removeLike(Email userEmail) {
        likedBy.remove(userEmail);
        validate(this);
    }

    public void hidePicture() {
        this.sharedToFollowers = false;
        validate(this);
    }

    public void unhidePicture() {
        this.sharedToFollowers = true;
        validate(this);
    }

    /* Required by JPA. Do not use in production code! */
    protected Picture() {
        super(Picture.class);
    }
}
