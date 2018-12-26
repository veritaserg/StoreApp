package com.store.springwebapp.service;

import java.util.Optional;

import org.springframework.security.core.Authentication;

public interface SecurityService {
    Optional<String> findLoggedInUsername();
    void autologin(String username, String password);
    Authentication getAuthentication();
}
