package com.store.springwebapp.service;

import com.store.springwebapp.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {


    void save(User user);
    Optional<User> findByUsername(String username);
   // Optional<User> findByUsername();
    User findById(Long id);
    List<User> findALL();

}
