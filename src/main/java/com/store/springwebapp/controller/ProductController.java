package com.store.springwebapp.controller;

import com.store.springwebapp.service.impl.ManufacturerServiceImpl;
import com.store.springwebapp.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;


    @Autowired
    private ManufacturerServiceImpl manufacturerService;

@RequestMapping(value = "/product", method = RequestMethod.GET)
    public String productList(Model model){
    model.addAttribute("productList",productService.findAll());
        return "product";
    }
}
