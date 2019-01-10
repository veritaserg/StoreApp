package com.store.springwebapp.service.impl;

import com.store.springwebapp.model.Role;
import com.store.springwebapp.model.User;
import com.store.springwebapp.repository.RoleRepository;
import com.store.springwebapp.repository.UserRepository;
import com.store.springwebapp.service.SecurityService;
import com.store.springwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SecurityService securityService;


    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        String role = String.valueOf(user.getRoles());
        Set<Role> roles = new HashSet<>();

        if (role.equals("[ROLE_ADMIN]"))
            roles.add(roleRepository.getOne(3L));

        else if (role.equals("[ROLE_MODERATOR]"))
            roles.add(roleRepository.getOne(2L));

        else
            roles.add(roleRepository.getOne(1L));

        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findALL() {
        return userRepository.findAll();
    }
}
