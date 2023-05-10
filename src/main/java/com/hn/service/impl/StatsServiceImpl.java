/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.service.impl;

import com.hn.repository.StatsRepository;
import com.hn.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class StatsServiceImpl implements StatsService{

    @Autowired
    private StatsRepository statsRepository;
    
    @Override
    public List<Object[]> cateStats() {
        return this.statsRepository.cateStats();
    }

    @Override
    public List<Object[]> productStats(String kw, Date fromDate, Date toDate) {
       return this.statsRepository.productStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> productMonthStats(String kw, Date fromDate, Date toDate) {
       return this.statsRepository.productMonthStats(kw, fromDate, toDate);
    }
    
}
