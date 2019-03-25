package com.robert.fullstack.exposition.authentication;

public class AuthToken {

    public String token;
    public String username;

    public AuthToken(String token, String username) {
        this.token = token;
        this.username = username;
    }
}
