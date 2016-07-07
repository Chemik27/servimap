package com.tpfinal.controller;

import org.springframework.web.bind.annotation.RestController;



import com.tpfinal.domain.Rating;
import com.tpfinal.service.RatingService;
import com.tpfinal.service.UserService;
import com.tpfinal.service.WorkService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LENOVO on 03/07/2016.
 */

@RestController
@RequestMapping("/qualify")
public class RatingController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RatingController.class);

    @Autowired
    RatingService ratingService;

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public @ResponseBody String saveRating(@RequestBody Rating rating ){
        logger.info("Guardando rating");
        ratingService.save(rating);
        return "Calificado";
    }
}



