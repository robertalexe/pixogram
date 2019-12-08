package com.robert.fullstack.domain.user;

import com.robert.fullstack.domain.ddd.BaseValueObject;
import com.robert.fullstack.domain.ddd.DDD;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

import static java.util.Collections.singletonList;

@DDD.ValueObject
public class Email extends BaseValueObject<Email> {

    @NotNull
    @NotEmpty
    @javax.validation.constraints.Email
    private final String value;

    public Email(String value) {
        super(Email.class);
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
    protected Email() {
        super(Email.class);
        this.value = null;
    }
}
