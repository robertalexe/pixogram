package com.robert.fullstack.domain.followers;

import com.robert.fullstack.domain.ddd.BaseValueObject;
import com.robert.fullstack.domain.ddd.DDD;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.singletonList;

@DDD.ValueObject
public class FollowerId extends BaseValueObject<FollowerId> {

    @NotNull @NotEmpty
    private final String value;

    public FollowerId() {
        super(FollowerId.class);
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
