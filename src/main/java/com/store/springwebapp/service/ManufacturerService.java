package com.store.springwebapp.service;

import com.store.springwebapp.model.Manufacturer;


import java.util.List;

public interface ManufacturerService {
    Manufacturer findByName(String name);
    List<Manufacturer> findAll();
    void save(Manufacturer manufacturer);
    void deleteId(Long id);
}
