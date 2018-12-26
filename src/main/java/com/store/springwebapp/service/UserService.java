package com.store.springwebapp.service;

import com.store.springwebapp.model.User;


public interface UserService {


    void save(User user);

    User findByUsername(String username);
}
