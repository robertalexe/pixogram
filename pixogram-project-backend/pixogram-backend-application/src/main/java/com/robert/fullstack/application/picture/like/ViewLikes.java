package com.robert.fullstack.application.picture.like;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.domain.pictures.PictureId;
import com.robert.fullstack.domain.pictures.Pictures;
import com.robert.fullstack.domain.user.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@DDD.ApplicationService
@Service
public class ViewLikes {

    @Autowired
    private Pictures pictures;

    public Set<Email> allLikes(PictureId pictureId) {
        Picture picture = pictures.getPicture(pictureId);
        return picture.getLikedBy();
    }
}
