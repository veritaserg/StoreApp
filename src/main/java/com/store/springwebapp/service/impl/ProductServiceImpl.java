package com.store.springwebapp.service.impl;

import com.store.springwebapp.model.Product;
import com.store.springwebapp.repository.ProductRepository;
import com.store.springwebapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

      private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public Product findById(Long id) {
        return  productRepository.getOne(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void update(Product product) {

productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
productRepository.deleteById(id);
    }
}
