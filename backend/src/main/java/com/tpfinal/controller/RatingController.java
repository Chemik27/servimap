package com.tpfinal.controller;


import com.sun.xml.internal.ws.api.message.Packet;
import com.tpfinal.domain.Rating;
import com.tpfinal.repository.IQualifyRepository;
import com.tpfinal.service.QualifyService;
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
    QualifyService qualifyService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    void addQualify(@RequestBody Rating rating){
        try {


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}



