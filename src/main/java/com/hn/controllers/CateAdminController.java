/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.controllers;

//import com.cloudinary.Cloudinary;
//import com.cloudinary.utils.ObjectUtils;
import com.hn.pojo.User;
import com.hn.service.UserService;

import java.io.IOException;
import static java.lang.System.console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dell
 */
@Controller
@ControllerAdvice
@RequestMapping("/")
public class CateAdminController {

    
    
    @Autowired
    private UserService userService;
    
    
    
    @GetMapping("/cate")
    public String cate(Model model) {
        //model.addAttribute("cate", new Category());
        return "cateStats";
    }

    @GetMapping("/userManager")
    public String userManager(Model model) {
        //model.addAttribute("cate", new Category());
        return "userManager";
    }

    @GetMapping("/addUserAdmin")
    public String addUserAdminView(Model model) {
        model.addAttribute("user", new User());
        return "addUserAdmin";
    }
    
    @PostMapping("/addUserAdmin")
    public String addUserAdmin(Model model, @ModelAttribute(value = "user") User user ) {
        String errMsg = "";
        String alertMsg = "";
        
        if (user.getPassword().equals(user.getConfirmPassword())) {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            
            user.setUserRole("ROLE_ADMIN");
            user.setActive(true);
            if (this.userService.addUser(user) == true) {
                return "redirect:/";
            } else {
                errMsg = "Da co loi xay ra!";
            }
        } else {
            errMsg = "The passwords doesn't match!";
        }

        model.addAttribute("errMsg", errMsg);

        return "addUserAdmin";
    }
}
