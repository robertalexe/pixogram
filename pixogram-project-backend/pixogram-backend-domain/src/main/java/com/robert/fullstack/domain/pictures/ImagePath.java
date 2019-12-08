package com.robert.fullstack.domain.pictures;

import com.robert.fullstack.domain.ddd.BaseValueObject;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

import static java.util.Collections.singletonList;

public class ImagePath extends BaseValueObject<ImagePath> {

    @NotNull @NotEmpty
    private final String path;

    public ImagePath(String path) {
        super(ImagePath.class);
        this.path = path;
        validate(this);
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return singletonList(path);
    }

    public String getPath() {
        return path;
    }

    /* Required by JPA. Do not use in production code! */
    protected ImagePath() {
        super(ImagePath.class);
        this.path = null;
    }
}
