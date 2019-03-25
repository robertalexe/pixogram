package com.robert.fullstack.domain;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@DDD.ValueObject
public abstract class BaseValueObject<T extends BaseValueObject<T>> implements Validable {

    private final Class<? extends T> classType;

    public BaseValueObject(Class<? extends T> classType) { this.classType = classType; };

    public abstract List<Object> attributesContainedInValueObject();

    @Override
    public final boolean equals(Object object) {
        if(object == this) return true;
        if(!classType.isInstance(object)) return false;
        T that = classType.cast(object);
        return that.attributesContainedInValueObject().equals(this.attributesContainedInValueObject());
    }

    @Override
    public final int hashCode() { return Objects.hashCode(attributesContainedInValueObject()); }

    @Override
    public String toString() {
        return String.format(
                "%s{attributes:%s}", classType.getSimpleName(), attributesContainedInValueObject()
        );
    }
}
