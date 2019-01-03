package com.store.springwebapp.service;

import java.util.Optional;

import org.springframework.security.core.Authentication;

public interface SecurityService {

    void autologin(String username, String password);
    String findLoggedInUsername();
}
