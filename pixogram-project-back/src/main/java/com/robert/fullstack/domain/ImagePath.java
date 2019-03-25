package com.robert.fullstack.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Collections;
import java.util.List;

@Embeddable
public class ImagePath extends BaseValueObject<ImagePath> {

    @Column(name = "IMAGE_PATH")
    private final String path;

    public ImagePath(String path) {
        super(ImagePath.class);
        this.path = path;
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return Collections.singletonList(path);
    }

    public String getPath() {
        return path;
    }

    private ImagePath() {
        super(ImagePath.class);
        this.path = null;
    }
}
