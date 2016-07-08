package com.tpfinal.service;

import com.tpfinal.domain.Rating;
import com.tpfinal.repository.IRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    IRatingRepository ratingRepository;

    public Rating createNew(){
        Rating rating = new Rating();
        rating.setConsideration(0L);
        rating.setPerformance(0L);
        rating.setRecommendation(0L);
        rating.setReliability(0L);
        return ratingRepository.save(rating);
    }
}
