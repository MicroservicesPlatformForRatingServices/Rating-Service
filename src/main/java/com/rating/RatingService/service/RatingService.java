package com.rating.RatingService.service;

import com.rating.RatingService.entites.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getAllRatings();

    Rating getByRatingId(String id);

    List<Rating> getAllRatingByUserId(String userId);

    List<Rating> getAllRatingByHotelId(String hotelId);
}
