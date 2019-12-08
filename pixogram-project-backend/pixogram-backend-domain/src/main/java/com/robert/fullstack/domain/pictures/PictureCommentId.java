package com.robert.fullstack.domain.pictures;

import com.robert.fullstack.domain.ddd.BaseValueObject;
import com.robert.fullstack.domain.ddd.DDD;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.singletonList;

@DDD.ValueObjectId
public class PictureCommentId extends BaseValueObject<PictureCommentId> {

    @NotNull @NotEmpty
    private final String value;

    public PictureCommentId() {
        super(PictureCommentId.class);
        this.value = UUID.randomUUID().toString();
        validate(this);
    }

    public String getValue() {
        return value;
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return singletonList(value);
    }
}