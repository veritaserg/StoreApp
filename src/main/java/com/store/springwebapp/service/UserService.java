package com.store.springwebapp.service;

import com.store.springwebapp.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {


    void save(User user);
    Optional<User> findByUsername(String username);
       User findById(Long id);
    void deleteById(Long id);
    List<User> findALL();

}
