package com.rating.RatingService.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Rating {

    private String userId;
    @Id
    private String ratingId;
    private int rating;
    private String hotelId;
    private String feedback;
}
