package com.tpfinal.service;

import com.tpfinal.domain.Rating;
import com.tpfinal.repository.IRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chemik on 06/07/2016.
 */
@Service
public class RatingService {

    @Autowired
    IRatingRepository ratingRepository;

    public void save(Rating rating){

        ratingRepository.save(rating);
    }

}
