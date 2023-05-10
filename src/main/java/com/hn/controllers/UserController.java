/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.controllers;


import com.hn.pojo.User;
import com.hn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author HUYNH NHU
 */
@Controller
public class UserController {

    @Autowired
    private UserService userDetailsService;

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        User newUser = new User();
        newUser.setId(5);
        model.addAttribute("user",newUser);
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user) {
        String errorMessage = "";
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (this.userDetailsService.registerUser(user) == true) 
                return "redirect:/login";
            else 
                errorMessage = "Đã có lỗi xảy ra!";
            
        } else 
            errorMessage = "Mật khẩu không khớp!";
        

        model.addAttribute("errorMessage", errorMessage);
        return "register";
    }
    
}
