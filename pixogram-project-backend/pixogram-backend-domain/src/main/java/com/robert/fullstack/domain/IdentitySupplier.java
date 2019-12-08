package com.robert.fullstack.domain;

import com.robert.fullstack.domain.ddd.DDD;
import org.springframework.security.core.userdetails.UserDetails;

@DDD.DomainService
public interface IdentitySupplier {
    UserDetails get();
}
