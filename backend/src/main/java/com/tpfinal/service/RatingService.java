package com.tpfinal.service;

import com.tpfinal.domain.Rating;
import com.tpfinal.repository.IRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RatingService {

    @Autowired
    IRatingRepository ratingRepository;

    public Rating createNew(Rating rating){
        return ratingRepository.save(rating);
    }

    public List<Rating> findByIdProvider(Long idUser) {
        return ratingRepository.findByIdProvider(idUser);
    }

    public Map<String, Object> getRatingAndComments(Long idUser) {
        List<Rating> allRatings = findByIdProvider(idUser);
        if(allRatings.isEmpty())
            return null;

        Double consideration = allRatings
                                .stream()
                                .mapToInt(Rating::getConsideration)
                                .average().getAsDouble();

        Double recomendation = allRatings
                                .stream()
                                .mapToInt(Rating::getRecommendation)
                                .average().getAsDouble();

        Double perfomace = allRatings
                                .stream()
                                .mapToInt(Rating::getPerformance)
                                .average().getAsDouble();

        Double reliability = allRatings
                                .stream()
                                .mapToInt(Rating::getReliability)
                                .average().getAsDouble();

        Rating finalRating = new Rating();
        finalRating.setConsideration(consideration.intValue());
        finalRating.setRecommendation(recomendation.intValue());
        finalRating.setPerformance(perfomace.intValue());
        finalRating.setReliability(reliability.intValue());

        List<String> comments = allRatings
                                    .stream()
                                    .map(Rating::getReviewText)
                                    .collect(Collectors.toList());

        Map <String, Object> ratingAndComments = new HashMap<String, Object>();
        ratingAndComments.put("finalRating", finalRating);
        ratingAndComments.put("comments", comments);

        return ratingAndComments;
    }
}
