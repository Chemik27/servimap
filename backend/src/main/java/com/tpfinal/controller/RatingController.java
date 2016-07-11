package com.tpfinal.controller;

import com.tpfinal.domain.Rating;
import com.tpfinal.service.RatingService;
import com.tpfinal.service.TransactionService;
import com.tpfinal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by redbee on 08/07/16.
 */
@RestController
@RequestMapping("/qualify")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @Autowired
    UserService userService;
    @Autowired
    TransactionService transactionService;

    private static final Logger logger = LoggerFactory.getLogger(RatingService.class);


    @RequestMapping(method= RequestMethod.POST, value = "/save")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody Rating rating){
        logger.info("Info rating:  " + rating);
        rating.setConsideration(rating.getConsideration());
        rating.setPerformance(rating.getPerformance());
        rating.setRecommendation(rating.getRecommendation());
        rating.setReliability(rating.getReliability());
        rating.setId_provider(rating.getId_provider());
        rating.setId_user(rating.getId_user());
        rating.setReview_text(rating.getReview_text());
        ratingService.createNew(rating);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{idTransaction}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getProfile(@PathVariable Long idUser) {
        logger.info("GET");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("toUser", userService.findByIdUser(idUser));
//        result.put("transaction", transactionService.findByToUserAll(idUser));
        return result;
    }

}
