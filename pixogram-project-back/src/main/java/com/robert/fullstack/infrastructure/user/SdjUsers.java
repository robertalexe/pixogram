package com.robert.fullstack.infrastructure.user;

import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.user.User;
import com.robert.fullstack.domain.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@DDD.RepositoryImpl
@Primary
public class SdjUsers implements Users, UserDetailsService {

    @Autowired
    private UsersSdj usersSdj;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> maybeUserFound = usersSdj.findById(userName);
        if(maybeUserFound.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    maybeUserFound.get().getId(),
                    maybeUserFound.get().getPassword(),
                    getAuthority()
            );
        }
        throw new UsernameNotFoundException(userName);
    }

    @Override
    public User findOne(String userName) {
        return usersSdj.findById(userName).orElseThrow( () -> new UsernameNotFoundException(userName));
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
