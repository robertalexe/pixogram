package com.robert.fullstack.application.picture;

import com.netflix.discovery.converters.Auto;
import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.IdentitySupplier;
import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.domain.pictures.Pictures;
import com.robert.fullstack.domain.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@DDD.ApplicationService
@Service
@Transactional
public class StorePicture {

    @Autowired
    private Pictures pictures;
    @Autowired
    private Users users;

    public void storePicture(MultipartFile multipartFile) {
        Picture storedPicture = pictures.storePictureForCurrentUser(multipartFile);
        users.findOne(storedPicture.getUploaderEmail()).addPicture(storedPicture);
    }
}
