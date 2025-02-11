package com.rating.RatingService.service.impl;

import com.rating.RatingService.entites.Rating;
import com.rating.RatingService.exception.ResourceNotFoundException;
import com.rating.RatingService.repository.RatingRepository;
import com.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating create(Rating rating) {
        String generatedId = UUID.randomUUID().toString();
        rating.setRatingId(generatedId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getByRatingId(String id) {
        return ratingRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
