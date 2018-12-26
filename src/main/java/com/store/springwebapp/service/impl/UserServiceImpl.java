package com.store.springwebapp.service.impl;

import com.store.springwebapp.model.Role;
import com.store.springwebapp.model.User;
import com.store.springwebapp.repository.RoleRepository;
import com.store.springwebapp.repository.UserRepository;
import com.store.springwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {
user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
     Set<Role> roles = new HashSet<>();
     roles.add(roleRepository.getOne(1l));

     user.setRoles(roles);
       userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
