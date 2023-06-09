/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.controllers;


import com.hn.pojo.Tour;
import com.hn.service.TourService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HUYNH NHU
 */
@RestController
@RequestMapping("/api")

public class ApiTourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/tours")
    public ResponseEntity<List<Tour>> getTours() {
        return new ResponseEntity<>(this.tourService.getTours(null, 0), HttpStatus.OK);
    }
    
    @DeleteMapping("/tours/{tourId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTour(@PathVariable(value = "tourId") int id){
        this.tourService.deleteTour(id);
    }
}
