package com.robert.fullstack.domain.ddd;

import java.util.List;

import static java.util.Objects.*;

@DDD.ValueObject
public abstract class BaseValueObject<T extends BaseValueObject<T>> implements Validable<T> {
    private final Class<? extends T> classType;

    protected BaseValueObject(Class<? extends T> classType) { this.classType = classType; }

    public abstract List<Object> attributesContainedInValueObject();

    @Override
    public final boolean equals(Object object) {
        if(object == this) return true;
        if(!classType.isInstance(object)) return false;
        T that = classType.cast(object);
        return this.attributesContainedInValueObject().equals(that.attributesContainedInValueObject());
    }

    @Override
    public final int hashCode() { return hash(attributesContainedInValueObject()); }

    @Override
    public String toString() {
        return String.format(
                "%s{attributes:%s}", classType.getSimpleName(), attributesContainedInValueObject()
        );
    }
}
