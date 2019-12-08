package com.robert.fullstack.application.picture;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.IdentitySupplier;
import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.domain.pictures.PictureId;
import com.robert.fullstack.domain.pictures.Pictures;
import com.robert.fullstack.domain.user.User;
import com.robert.fullstack.domain.user.Users;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@DDD.ApplicationService
@Service
public class DownloadPicture {

    @Autowired
    private Pictures pictures;
    @Autowired
    private Users users;
    @Autowired
    private IdentitySupplier identitySupplier;

    public byte[] downloadPicture(PictureId pictureId) throws IOException {
        Picture picture = pictures.getPicture(pictureId);
        InputStream in = new BufferedInputStream(new FileInputStream(picture.getImagePath().getPath()));
        return IOUtils.toByteArray(in);
    }

    public byte[] downloadProfilePicture() throws IOException {
        User user = users.findOne(identitySupplier.get().getUsername());
        return downloadPicture(user.getProfilePictureId());
    }
}
