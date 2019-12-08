package com.robert.fullstack.domain.pictures;

import com.robert.fullstack.domain.ddd.BaseValueObject;
import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.user.NameFragment;

import java.util.List;

import static java.util.Arrays.asList;

@DDD.ValueObject
public class PictureInfo extends BaseValueObject<PictureInfo> {

    private final NameFragment name;
    private final NameFragment originalName;
    private final Description description;

    public PictureInfo(NameFragment name, NameFragment originalName, Description description) {
        super(PictureInfo.class);
        this.name = name;
        this.originalName = originalName;
        this.description = description;
        validate(this);
    }

    public NameFragment getName() {
        return name;
    }

    public NameFragment getOriginalName() {
        return originalName;
    }

    public Description getDescription() {
        return description;
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return asList(name, originalName, description);
    }

    /* Required by JPA. Do not use in production code! */
    protected PictureInfo() {
        super(PictureInfo.class);
        this.name = null;
        this.originalName = null;
        this.description = null;
    }
}