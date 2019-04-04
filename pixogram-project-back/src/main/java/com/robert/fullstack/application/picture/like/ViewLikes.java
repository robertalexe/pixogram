package com.robert.fullstack.application.picture.like;

import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.domain.pictures.Pictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@DDD.ApplicationService
@Service
public class ViewLikes {

    @Autowired
    private Pictures pictures;

    public Set<String> allLikes(String pictureId) {
        Picture picture = pictures.getPicture(pictureId);
        return picture.getLikedBy();
    }
}
