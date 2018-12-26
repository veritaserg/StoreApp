package com.store.springwebapp.service.impl;

import com.store.springwebapp.model.Role;
import com.store.springwebapp.model.User;
import com.store.springwebapp.repository.UserRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));

        user.orElseThrow(() -> new UsernameNotFoundException("No user found with username: " + username));

        logger.debug("Method loadUserByUsername was able to find the user: " + user.get().getUsername());

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.get().getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
                user.get().getPassword(), grantedAuthorities);
    }
}