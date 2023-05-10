/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.handlers;

import com.hn.pojo.User;
import com.hn.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;



/**
 *
 * @author HUYNH NHU
 */
//tự tạo hạt đậu, khi cần lấy ra
@Component 
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
    @Autowired
    private UserService userService;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        User u = this.userService.getUserByUsername(a.getName());
        request.getSession().setAttribute("currentUser", u);
       
        response.sendRedirect("/SaleWeb/");    }
    
}
