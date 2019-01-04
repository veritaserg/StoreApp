package com.store.springwebapp.service;

import com.store.springwebapp.model.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);

    Product findById(Long id);

    List<Product> findAll();

    void update(Product product);

    void deleteById(Long id);
}
