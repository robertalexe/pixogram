package com.robert.fullstack.application.picture;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.pictures.Description;
import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.domain.pictures.Pictures;
import com.robert.fullstack.domain.user.NameFragment;
import com.robert.fullstack.domain.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                new NameFragment(storePictureCommand.getPictureName()),
                storePictureCommand.isSharedToFollowers(),
                new Description(storePictureCommand.getPictureDescription())
        );
        return storedPicture;
    }
}
