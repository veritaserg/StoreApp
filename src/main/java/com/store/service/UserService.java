package com.store.service;

import com.store.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
