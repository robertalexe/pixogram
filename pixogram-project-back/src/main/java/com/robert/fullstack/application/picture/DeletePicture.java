package com.robert.fullstack.application.picture;

import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.pictures.Pictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DDD.ApplicationService
@Service
public class DeletePicture {

    @Autowired
    private Pictures pictures;

    public void delete(String pictureId) {
        pictures.delete(pictureId);
    }
}
