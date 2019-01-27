package com.store.springwebapp.service.impl;

import com.store.springwebapp.model.Manufacturer;
import com.store.springwebapp.repository.ManufacturerRepository;
import com.store.springwebapp.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer findByName(String name) {
        return manufacturerRepository.findByName(name);
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public void save(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public void deleteId(Long id) {
        manufacturerRepository.deleteById(id);

    }

}
