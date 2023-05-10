/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hn.repository;

import com.hn.pojo.User;
import java.util.List;



/**
 *
 * @author HUYNH NHU
 */
public interface UserRepository {
    User getUserByUsername(String username);
    boolean registerUser(User user);
    boolean addUser(User user);
    User getUserById(int id);
   
}
