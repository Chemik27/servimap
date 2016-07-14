package com.tpfinal.service;

import com.tpfinal.domain.Rating;
import com.tpfinal.repository.IRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    IRatingRepository ratingRepository;

    public Rating createNew(Rating rating){
        return ratingRepository.save(rating);
    }

    public Rating findByIdProvider(Long idUser) {
        return ratingRepository.findByIdProvider(idUser);
    }
}
