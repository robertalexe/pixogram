package com.robert.fullstack.domain.pictures;

import com.robert.fullstack.domain.ddd.BaseValueObject;
import com.robert.fullstack.domain.ddd.DDD;

import javax.validation.constraints.Size;
import java.util.List;

import static java.util.Collections.singletonList;

@DDD.ValueObject
public class Description extends BaseValueObject<Description> {
    @Size(max = 5000)
    private String value;

    public Description(String value) {
        super(Description.class);
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
    private Description() {
        super(Description.class);
        this.value = null;
    }
}
