/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.formatters;


import com.hn.pojo.Category;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author HUYNH NHU
 */
public class CategoryFormatter implements Formatter <Category>{

    @Override
    public String print(Category t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Category parse(String id, Locale locale) throws ParseException {
        Category c =new Category();
        c.setId(Integer.parseInt(id));
        return c;
    }
    
}
