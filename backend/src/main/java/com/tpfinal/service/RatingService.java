package com.tpfinal.service;

import com.tpfinal.domain.Rating;
import com.tpfinal.repository.IRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Chemik on 06/07/2016.
 */
public class RatingService {

    @Autowired
    IRatingRepository ratingRepository;

    public void save(Rating rating){

        ratingRepository.save(rating);
    }

}
