package com.robert.fullstack.application.mygallery;

import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.IdentitySupplier;
import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.domain.pictures.Pictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@DDD.ApplicationService
@Service
public class ConsultMyGallery {

    @Autowired
    private Pictures pictures;
    @Autowired
    private IdentitySupplier identitySupplier;

    public Set<String> getAllImageIds() {
        return pictures.getPicturesForUser(
                identitySupplier.get().getUsername()
        ).stream().map(Picture::getPictureId).collect(Collectors.toSet());
    }
}
