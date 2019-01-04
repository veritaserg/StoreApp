package com.store.springwebapp.service;

import com.store.springwebapp.model.Manufacturer;

public interface ManufacturerService {
    Manufacturer findByName(String name);
}
