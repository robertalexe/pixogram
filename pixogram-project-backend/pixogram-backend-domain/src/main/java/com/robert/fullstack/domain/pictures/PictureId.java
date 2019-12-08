package com.robert.fullstack.domain.pictures;

import com.robert.fullstack.domain.ddd.BaseValueObject;
import com.robert.fullstack.domain.ddd.DDD;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

import static java.util.Collections.singletonList;

@DDD.ValueObject
public class PictureId extends BaseValueObject<PictureId> {

    @NotNull @NotEmpty
    private final String value;

    public PictureId(String value) {
        super(PictureId.class);
        this.value = value;
        validate(this);
    }

    public String getValue() {
        return value;
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return singletonList(value);
    }

    /* Required by JPA. Do not use in production code! */
    protected PictureId() {
        super(PictureId.class);
        this.value = null;
    }
}
