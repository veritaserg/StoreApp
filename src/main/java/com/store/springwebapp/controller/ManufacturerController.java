package com.store.springwebapp.controller;

import com.store.springwebapp.model.Manufacturer;
import com.store.springwebapp.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping(value = "/manufacturer", method = RequestMethod.GET)
    public String manufacturer(Model model) {
        model.addAttribute("manufacturerList", manufacturerService.findAll());
        return "manufacturer";
    }
    @RequestMapping(value = "/manufacturer/add", method = RequestMethod.POST)
    public String addManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
        manufacturerService.save(manufacturer);

        return "redirect:/manufacturer";
    }
    @RequestMapping("/manufacturer/delete/{id}")
    public String deleteManufacturer(@PathVariable("id") Long id) {
        manufacturerService.deleteId(id);
        return "redirect:/manufacturer";
    }

    @RequestMapping(value = "/manufacturer/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
        manufacturerService.save(manufacturer);

        return "redirect:/manufacturer";
    }



}