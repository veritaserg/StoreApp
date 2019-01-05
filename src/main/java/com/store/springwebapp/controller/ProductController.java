package com.store.springwebapp.controller;

import com.store.springwebapp.model.Product;
import com.store.springwebapp.service.impl.ManufacturerServiceImpl;
import com.store.springwebapp.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
     productService.save(product);

        return "redirect:/product";
    }
    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);

        return "redirect:/product";
    }
    @RequestMapping("edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("productList", productService.findAll());

        return "product";
    }
    @RequestMapping("productdata/{id}")
    public String productData(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", productService.findById(id));

        return "productdata";
    }






}
