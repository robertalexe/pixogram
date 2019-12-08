package com.robert.fullstack.domain.user;

import com.robert.fullstack.domain.ddd.DomainConstraintViolationException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordTest {

    @Test(expected= DomainConstraintViolationException.class)
    public void should_reject_null_password() {
        new Password(null);
    }

    @Test(expected= DomainConstraintViolationException.class)
    public void should_reject_empty_password() {
        new Password("");
    }

    @Test(expected = DomainConstraintViolationException.class)
    public void should_reject_small_password() {
        new Password("test");
    }

    @Test(expected = DomainConstraintViolationException.class)
    public void should_reject_too_large_password() {
        new Password("this is a very long password");
    }

    @Test
    public void should_create_password_for_policy() {
        String passwordValue = "NicePwd";
        Password password = new Password(passwordValue);
        assertThat(password).isNotNull();
        assertThat(password.getValue()).isEqualTo(passwordValue);
    }
}