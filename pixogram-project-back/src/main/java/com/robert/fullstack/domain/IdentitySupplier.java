package com.robert.fullstack.domain;

import org.springframework.security.core.userdetails.UserDetails;

@DDD.DomainService
public interface IdentitySupplier {

    UserDetails get();
}
