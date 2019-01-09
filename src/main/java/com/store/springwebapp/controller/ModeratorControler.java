package com.store.springwebapp.controller;

import com.store.springwebapp.model.Product;
import com.store.springwebapp.service.ManufacturerService;
import com.store.springwebapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ModeratorControler {

    @Autowired
    ProductService productService;
    @Autowired
    ManufacturerService manufacturerService;

    @RequestMapping(value = "/moderator", method = RequestMethod.GET)
    public String moderator(Model model) {
        model.addAttribute("productList", productService.findAll());
        model.addAttribute("manufactureList", manufacturerService.findAll());
        return "moderator";

    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
               productService.save(product);

        return "redirect:/moderator";
    }

    @RequestMapping("edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("manufactureList", manufacturerService.findAll());
        return "editproduct";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/moderator";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("product") Product product) {
               productService.save(product);

        return "redirect:/moderator";
    }
}
