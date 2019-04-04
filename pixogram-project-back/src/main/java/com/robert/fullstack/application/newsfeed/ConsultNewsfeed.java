package com.robert.fullstack.application.newsfeed;

import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.IdentitySupplier;
import com.robert.fullstack.domain.newsfeed.NewsfeedPictures;
import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.domain.pictures.Pictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@DDD.ApplicationService
@Service
public class ConsultNewsfeed {

    @Autowired
    private NewsfeedPictures newsfeedPictures;
    @Autowired
    private IdentitySupplier identitySupplier;

    public Set<String> getAllImageIdsForNewsfeed() {
        return newsfeedPictures.findPictureIdsForNewsfeed().stream().map(Picture::getPictureId).collect(Collectors.toSet());
    }

}
