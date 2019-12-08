package com.robert.fullstack.application.picture.comment;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.domain.pictures.PictureComment;
import com.robert.fullstack.domain.pictures.PictureId;
import com.robert.fullstack.domain.pictures.Pictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@DDD.ApplicationService
@Service
public class ViewComments {

    @Autowired
    private Pictures pictures;

    public Set<PictureComment> allComments(PictureId pictureId) {
        Picture picture = pictures.getPicture(pictureId);
        return picture.getComments();
    }
}
