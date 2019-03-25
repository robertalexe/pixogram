package com.robert.fullstack.infrastructure.user;

import com.robert.fullstack.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersSdj extends JpaRepository<User, String> {
}
