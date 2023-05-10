    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.controllers;

import com.hn.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */

@Controller
@RequestMapping("/")
public class AdminController {
    
    @Autowired
   private StatsService statsService;
    
    @GetMapping("/cateStats")
    public String cateStats(Model model){
        model.addAttribute("cateStats", this.statsService.cateStats());
        return "cateStats";
    }
    
    @GetMapping("/prodStats")
    public String prodStats(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException{
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        Date fromDate = null;
        Date toDate = null;
        try {
            
            String from = params.getOrDefault("fromDate", null);
            if (from != null )  
                fromDate = f.parse(from);

            
            String to = params.getOrDefault("toDate", null);
            if (to != null )
                toDate = f.parse(to);
        } catch (ParseException ex){
            ex.printStackTrace();
        }
        model.addAttribute("prodStats", this.statsService.productStats(kw, fromDate, toDate));
        
        return "prodStats";
    }
    @GetMapping("/prodMonthStats")
    public String prodMonthStats(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException{
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        Date fromDate = null;
        Date toDate = null;
        try {
            
            String from = params.getOrDefault("fromDate", null);
            if (from != null )  
                fromDate = f.parse(from);

            
            String to = params.getOrDefault("toDate", null);
            if (to != null )
                toDate = f.parse(to);
        } catch (ParseException ex){
            ex.printStackTrace();
        }
        model.addAttribute("prodMonthStats", this.statsService.productMonthStats(kw, fromDate, toDate));
        
        return "prodMonthStats";
    }
}
