package com.robert.fullstack.domain.user;

import com.robert.fullstack.domain.ddd.BaseValueObject;
import com.robert.fullstack.domain.ddd.DDD;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

import static java.util.Collections.singletonList;

@DDD.ValueObject
public class NameFragment extends BaseValueObject<NameFragment> {

    @NotNull @NotEmpty
    private final String value;

    public NameFragment(String value) {
        super(NameFragment.class);
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
    protected NameFragment() {
        super(NameFragment.class);
        this.value = null;
    }
}
