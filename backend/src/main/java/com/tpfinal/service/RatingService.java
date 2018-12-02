package com.tpfinal.service;

import com.tpfinal.domain.Rating;
import com.tpfinal.domain.State;
import com.tpfinal.domain.Transaction;
import com.tpfinal.repository.IRatingRepository;
import com.tpfinal.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RatingService {

    @Autowired
    IRatingRepository ratingRepository;

    @Autowired
    ITransactionRepository transactionRepository;

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
                                    .map(this::formatComment)
                                    .collect(Collectors.toList());

        Map <String, Object> ratingAndComments = new HashMap<String, Object>();
        ratingAndComments.put("finalRating", finalRating);
        ratingAndComments.put("comments", comments);

        return ratingAndComments;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

    private String formatComment(Rating rating) {
        String date = rating.getReviewDate() != null ? " - " + sdf.format(rating.getReviewDate()) : "";
        return rating.getReviewText() + date;
    }

    public void save(Rating rating) {
        Transaction tx = transactionRepository.findOne(rating.getIdTransaction());
        if(tx.getState().toString().equals(State.TRX_CALIFICATED_FOR_PROVIDER.toString()) ) {
            tx.setState(State.TRX_CLOSED);
        }
        if(tx.getState().toString().equals(State.TRX_COMPLETED.toString()) ) {
            tx.setState(State.TRX_CALIFICATED_FOR_PROVIDER);
        }

        transactionRepository.save(tx);
        ratingRepository.save(rating);
    }
}
