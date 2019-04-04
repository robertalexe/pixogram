package com.robert.fullstack.application.picture;

import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.IdentitySupplier;
import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.domain.pictures.Pictures;
import com.robert.fullstack.domain.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@DDD.ApplicationService
@Service
@Transactional
public class StorePicture {

    @Autowired
    private Pictures pictures;
    @Autowired
    private Users users;

    public Picture storePicture(StorePictureCommand storePictureCommand) {
        Picture storedPicture = pictures.storePictureForCurrentUser(
                storePictureCommand.getMultipart(),
                storePictureCommand.getPictureName(),
                storePictureCommand.isSharedToFollowers(),
                storePictureCommand.getPictureDescription()
        );
        return storedPicture;
    }
}
