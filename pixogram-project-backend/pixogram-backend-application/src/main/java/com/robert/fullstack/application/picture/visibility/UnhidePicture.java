package com.robert.fullstack.application.picture.visibility;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.pictures.PictureId;
import com.robert.fullstack.domain.pictures.Pictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DDD.ApplicationService
@Service
public class UnhidePicture {

    @Autowired
    private Pictures pictures;

    public void unhide(PictureId pictureId) {
        pictures.unhide(pictureId);
    }
}