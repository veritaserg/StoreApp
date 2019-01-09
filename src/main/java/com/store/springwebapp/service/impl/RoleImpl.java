package com.store.springwebapp.service.impl;

import com.store.springwebapp.model.Role;
import com.store.springwebapp.repository.RoleRepository;
import com.store.springwebapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
