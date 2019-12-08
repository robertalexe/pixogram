package com.robert.fullstack.domain.user;

import com.robert.fullstack.domain.ddd.BaseValueObject;
import com.robert.fullstack.domain.ddd.DDD;

import javax.validation.constraints.NotNull;
import java.util.List;

import static java.util.Arrays.asList;

@DDD.ValueObject
public class UserDetails extends BaseValueObject<UserDetails> {

    @NotNull
    private final NameFragment firstName;
    @NotNull
    private final NameFragment lastName;

    public UserDetails(NameFragment firstName, NameFragment lastName) {
        super(UserDetails.class);
        this.firstName = firstName;
        this.lastName = lastName;
        validate(this);
    }

    public NameFragment getFirstName() {
        return firstName;
    }

    public NameFragment getLastName() {
        return lastName;
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return asList(firstName, lastName);
    }

    /* Required by JPA. Do not use in production code! */
    protected UserDetails() {
        super(UserDetails.class);
        this.firstName = null;
        this.lastName = null;
    }
}
