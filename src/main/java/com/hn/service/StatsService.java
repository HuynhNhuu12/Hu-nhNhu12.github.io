/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public interface StatsService {
    List<Object[]> cateStats();
    List<Object[]> productStats(String kw, Date fromDate, Date toDate);
    List<Object[]> productMonthStats(String kw, Date fromDate, Date toDate);
}
