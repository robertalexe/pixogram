package com.robert.fullstack.application.mygallery;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.IdentitySupplier;
import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.domain.pictures.PictureId;
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

    public Set<PictureId> getAllImageIds() {
        return pictures.getPicturesForMyGallery(
        ).stream().map(Picture::getId).collect(Collectors.toSet());
    }
}
