package com.robert.fullstack.domain.pictures;

import com.robert.fullstack.domain.ddd.BaseValueObject;
import com.robert.fullstack.domain.ddd.DDD;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

import static java.util.Collections.singletonList;

@DDD.ValueObject
public class Comment extends BaseValueObject<Comment> {

    @NotEmpty @Size(max = 4000)
    private final String value;

    public Comment(String value) {
        super(Comment.class);
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
    protected Comment() {
        super(Comment.class);
        this.value = null;
    }
}
