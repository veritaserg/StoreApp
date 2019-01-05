package com.store.springwebapp.service.impl;

import com.store.springwebapp.model.Manufacturer;
import com.store.springwebapp.repository.ManufacturerRepository;
import com.store.springwebapp.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer findByName(String name) {
        return manufacturerRepository.findByName(name);
    }
}
