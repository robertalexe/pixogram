package com.robert.fullstack.domain.user;

import com.robert.fullstack.domain.ddd.DomainConstraintViolationException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailTest {

    @Test(expected = DomainConstraintViolationException.class)
    public void should_reject_email_with_empty_address() {
        new Email("");
    }

    @Test(expected = DomainConstraintViolationException.class)
    public void should_reject_email_with_null_value() {
        new Email(null);
    }

    @Test(expected = DomainConstraintViolationException.class)
    public void should_reject_email_with_invalid_address() {
        new Email("abc@");
    }

    @Test
    public void should_create_email_with_proper_address() {
        String validEmail = "test@abc.com";
        Email email = new Email(validEmail);
        assertThat(email).isNotNull();
        assertThat(email.getValue()).isEqualTo(validEmail);
    }
}