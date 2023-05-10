/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.controllers;

import com.hn.service.CategoryService;
import com.hn.service.TourService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HUYNH NHU
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:messages.properties")

public class IndexController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TourService tourService;
    @Autowired
    private Environment env;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
    }

    @RequestMapping("/")
    public String index(Model model,
            @RequestParam Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("tours", this.tourService.getTours(params, 0));
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        model.addAttribute("countTour", this.tourService.countTour());

        return "index";
    }

    @GetMapping("/tours/{tourId}")
    public String tourDetails(Model model, @PathVariable(value = "tourId") int id) {
        model.addAttribute("tour", this.tourService.getTourById(id));
        return "details";
    }
}
