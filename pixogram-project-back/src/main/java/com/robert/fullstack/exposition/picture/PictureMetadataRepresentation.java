package com.robert.fullstack.exposition.picture;

import com.robert.fullstack.domain.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public class PictureMetadataRepresentation {

    public String name;
    public String description;
    public List<String> likedBy;
    public boolean visibleToFollowers;

    public PictureMetadataRepresentation(Picture picture) {
        this.name = picture.getName();
        this.description = picture.getDescription();
        this.likedBy = new ArrayList<>(picture.getLikedBy());
        this.visibleToFollowers = picture.isSharedToFollowers();
    }
}
