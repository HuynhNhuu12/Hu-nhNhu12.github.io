/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hn.repository;


import com.hn.pojo.Booking;
import com.hn.pojo.Comments;
import com.hn.pojo.Tour;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HUYNH NHU
 */
public interface TourRepository {
    List<Tour> getTours(Map<String, String> params, int page);
    int countTour();
    boolean addTour(Tour t);
    boolean deleteTour(int id);
    Tour getTourById(int id);
    List<Comments> getComments(int tourId);
    Comments addComment(String content, int tourId);
    boolean addBooking(Booking book);
    
}


