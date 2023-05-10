/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hn.service;

import com.hn.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author HUYNH NHU
 */
public interface UserService extends UserDetailsService{
    User getUserByUsername(String username);
    boolean registerUser(User user);
    boolean addUser(User user);
    User getUserById(int id);
}
