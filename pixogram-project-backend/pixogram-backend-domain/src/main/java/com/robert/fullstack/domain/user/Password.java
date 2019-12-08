package com.robert.fullstack.domain.user;

import com.robert.fullstack.domain.ddd.BaseValueObject;
import com.robert.fullstack.domain.ddd.DDD;

import javax.validation.Payload;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.*;
import java.util.List;

import static java.util.Collections.singletonList;

@DDD.ValueObject
public class Password extends BaseValueObject<Password> {

    @PasswordValid
    private final String value;

    public Password(String value) {
        super(Password.class);
        this.value = value;
        validate(this);
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return singletonList(value);
    }

    public String getValue() {
        return value;
    }

    @Documented
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 20)
    @javax.validation.Constraint(validatedBy = {})
    public @interface PasswordValid {
        String message() default "Password is not valid";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

    /* Required by JPA. Do not use in production code! */
    protected Password() {
        super(Password.class);
        this.value = null;
    }
}
