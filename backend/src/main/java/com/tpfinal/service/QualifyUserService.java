package com.tpfinal.service;

import com.sun.javafx.collections.MappingChange;
import com.tpfinal.domain.QualifyUser;
import com.tpfinal.domain.State;
import com.tpfinal.domain.Transaction;
import com.tpfinal.repository.IQualifyUserRepository;
import com.tpfinal.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Chemik on 27/07/2016.
 */
@Service
public class QualifyUserService {

    @Autowired
    IQualifyUserRepository qualifyUserRepository;

    @Autowired
    ITransactionRepository transactionRepository;

    public List<QualifyUser> findByIdProvider(Long idUser) {
        return qualifyUserRepository.findByIdProvider(idUser);
    }

    public Map<String, Object> getRatingAndComments(Long idUser) {
        List<QualifyUser> allRatings = findByIdProvider(idUser);
        if(allRatings.isEmpty())
            return null;

        Double consideration = allRatings
                .stream()
                .mapToInt(QualifyUser::getConsideration)
                .average().getAsDouble();

        Double recomendation = allRatings
                .stream()
                .mapToInt(QualifyUser::getRecommendation)
                .average().getAsDouble();

        Double perfomace = allRatings
                .stream()
                .mapToInt(QualifyUser::getPerformance)
                .average().getAsDouble();

        Double reliability = allRatings
                .stream()
                .mapToInt(QualifyUser::getReliability)
                .average().getAsDouble();

        QualifyUser finalRating = new QualifyUser();
        finalRating.setConsideration(consideration.intValue());
        finalRating.setRecommendation(recomendation.intValue());
        finalRating.setPerformance(perfomace.intValue());
        finalRating.setReliability(reliability.intValue());

        List<String> comments = allRatings
                .stream()
                .map(QualifyUser::getReviewText)
                .collect(Collectors.toList());

        Map<String, Object> ratingAndComments = new HashMap<String, Object>();
        ratingAndComments.put("finalRating", finalRating);
        ratingAndComments.put("comments", comments);

        return ratingAndComments;
    }

    public void save(QualifyUser qualifyUser) {
        Transaction tx = transactionRepository.findOne(qualifyUser.getIdTransaction());
        tx.setState(State.TRX_CLOSED);
        transactionRepository.save(tx);
        qualifyUserRepository.save(qualifyUser);
    }
}
