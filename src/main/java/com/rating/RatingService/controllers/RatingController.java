package com.rating.RatingService.controllers;

import com.rating.RatingService.entites.Rating;
import com.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping("/getAllRatings")
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
    }

    @GetMapping("/getRatingById/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getByRatingId(id));
    }

    @GetMapping("/getAllRatingsByUser/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUser(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatingByUserId(userId));
    }

    @GetMapping("/getAllRatingsOfHotel")
    public ResponseEntity<List<Rating>> getAllRatingsOfHotel(@RequestParam(name = "hotelId", defaultValue = "") String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatingByHotelId(hotelId));
    }
}
