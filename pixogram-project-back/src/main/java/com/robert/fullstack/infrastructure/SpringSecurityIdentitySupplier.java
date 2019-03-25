package com.robert.fullstack.infrastructure;

import com.robert.fullstack.domain.IdentitySupplier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityIdentitySupplier implements IdentitySupplier {

    @Override
    public UserDetails get() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            return (UserDetails)principal;
        }
        throw new UsernameNotFoundException(principal.toString());
    }
}
