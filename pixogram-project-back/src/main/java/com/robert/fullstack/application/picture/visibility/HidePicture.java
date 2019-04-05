package com.robert.fullstack.application.picture.visibility;

import com.netflix.discovery.converters.Auto;
import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.pictures.Pictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DDD.ApplicationService
@Service
public class HidePicture {

    @Autowired
    private Pictures pictures;

    public void hide(String pictureId) {
        pictures.hide(pictureId);
    }
}
