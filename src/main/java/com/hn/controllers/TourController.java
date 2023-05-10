/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.controllers;

import com.hn.pojo.Booking;
import com.hn.pojo.Tour;
import com.hn.pojo.User;
import com.hn.repository.TourRepository;
import com.hn.repository.UserRepository;
import com.hn.service.TourService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HUYNH NHU
 */
@Controller
@RequestMapping("/admin")
public class TourController {

    @Autowired
    private TourService tourService;
    
    @Autowired
    private TourRepository tourRepository;
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/tours")
    public String list(Model model) {
        model.addAttribute("tour", new Tour());
        return "tours";
    }

    @PostMapping("/tours")
    public String add(@ModelAttribute(value = "tour") @Valid Tour t,
            BindingResult r) {
        if (r.hasErrors()) {
            return "tours";
        }

        if (this.tourService.addTour(t) == true) {
            return "redirect:/";
        }
        return "tours";
    }
    
//    @GetMapping("/booking/{id}")
//    public String tourDetail(ModelMap modelMap, @PathVariable("id") int id, Model model) {
//        Tour tour = tourService.getTourById(id);
//        model.addAttribute("tour",tour);
////        modelMap.put("booking", new Booking());
//        return "booking";
//    }
//    
//    @PostMapping("/bookTour")
//    public String booking(HttpSession session ,ModelMap modelMap,@RequestParam(name = "tourId") int id, @RequestParam(name = "userId") String uId){
//        System.out.println(id);
//        User user = (User) session.getAttribute("currentUser");
////        System.out.println(userDetails.getUsername());
//        
//        Booking b = new Booking();
//        
//        b.setTourId(this.tourRepository.getTourById(id));   
//        b.setUserId(this.userRepository.getUserByUsername(uId));
//        this.tourRepository.addBooking(b);
//        
//        return "redirect:/";
//    }

//    @GetMapping("/introduce")
//    public String intro(){
//    
//        return "introduce";
//    }
//    
//    @GetMapping("/booking")
//    public String booking(){
//    
//        return "book";
//    }
}
