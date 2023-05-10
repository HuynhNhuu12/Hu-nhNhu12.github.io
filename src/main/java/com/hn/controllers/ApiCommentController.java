/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.controllers;


import com.hn.pojo.Comments;
import com.hn.service.TourService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HUYNH NHU
 */

@RestController
@RequestMapping("/api")
public class ApiCommentController {
    
    @Autowired
    private TourService tourService;
    
    @GetMapping("/tours/{tourId}/comments")
    public ResponseEntity<List<Comments>> getComments(@PathVariable(value = "tourId") int id) {
        return new ResponseEntity<>(this.tourService.getComments(id), HttpStatus.OK);
    }
    
//    seri doi tuong
    @PostMapping(path="/tours/{tourId}/comments", produces={
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comments> addComment(
            @RequestBody Map<String, String> params){
        String content = params.get("content");
       int tourId = Integer.parseInt(params.get("tourId"));
        Comments c = this.tourService.addComment(content, tourId);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
}
