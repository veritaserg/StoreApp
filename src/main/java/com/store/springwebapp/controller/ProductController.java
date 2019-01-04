package com.store.springwebapp.controller;

import com.store.springwebapp.service.impl.ManufacturerServiceImpl;
import com.store.springwebapp.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;


    @Autowired
    private ManufacturerServiceImpl manufacturerService;


}
