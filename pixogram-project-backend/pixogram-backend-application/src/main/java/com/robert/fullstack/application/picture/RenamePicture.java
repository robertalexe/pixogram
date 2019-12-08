package com.robert.fullstack.application.picture;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.pictures.PictureId;
import com.robert.fullstack.domain.pictures.Pictures;
import com.robert.fullstack.domain.user.NameFragment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DDD.ApplicationService
@Service
public class RenamePicture {

    @Autowired
    private Pictures pictures;

    public void rename(NameFragment newImageName, PictureId pictureId) {
        pictures.rename(newImageName, pictureId);
    }
}
