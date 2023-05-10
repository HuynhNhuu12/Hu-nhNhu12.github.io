/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.service.impl;


import com.hn.pojo.Booking;
import com.hn.pojo.Comments;
import com.hn.pojo.Tour;
import com.hn.repository.TourRepository;
import com.hn.service.TourService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HUYNH NHU
 */
@Service
public class TourServiceImpl implements  TourService{

    @Autowired
    private TourRepository tourRepository;
    
    @Override
    public List<Tour> getTours(Map<String, String> params, int page) {
        return this.tourRepository.getTours(params, page);
    }

    @Override
    public int countTour() {
        return this.tourRepository.countTour();
    }

    @Override
    public boolean addTour(Tour t) {
        t.setImage("https://res.cloudinary.com/huynhnhu/image/upload/v1658763728/cld-sample-2.jpg");
        return this.tourRepository.addTour(t);
    }

    @Override
    public boolean deleteTour(int id) {
        return this.tourRepository.deleteTour(id);
    }

    @Override
    public Tour getTourById(int id) {
        return this.tourRepository.getTourById(id);
    }

    @Override
    public List<Comments> getComments(int tourId) {
        return this.tourRepository.getComments(tourId);
    }

    @Override
    public Comments addComment(String content, int tourId) {
        
        return this.tourRepository.addComment(content, tourId);
    }

    @Override
    public boolean addBooking(Booking book) {
        return this.tourRepository.addBooking(book);
    }
    
}
