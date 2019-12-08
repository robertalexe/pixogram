package com.robert.fullstack.domain.pictures;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.user.Email;
import com.robert.fullstack.domain.user.NameFragment;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@DDD.Repository
public interface Pictures {

    Picture storePictureForCurrentUser(MultipartFile multipartFile, NameFragment name, boolean sharedToFollowers, Description description);

    Picture getPicture(PictureId pictureId);

    Set<Picture> getPicturesForUser(Email username, boolean sharedToFollowers);

    Set<Picture> getPicturesForMyGallery();

    void addComment(PictureId pictureId, Comment comment);

    void addLike(PictureId pictureId);

    void removeLike(PictureId pictureId);

    void rename(NameFragment newImageName, PictureId pictureId);

    void delete(PictureId pictureId);

    void hide(PictureId pictureId);

    void unhide(PictureId pictureId);
}
