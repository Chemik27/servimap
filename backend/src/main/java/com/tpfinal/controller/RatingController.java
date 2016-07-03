package com.tpfinal.controller;

import com.tpfinal.service.TransactionService;
import com.tpfinal.service.UserService;
import com.tpfinal.service.WorkService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    UserService userService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    WorkService workService;

    @RequestMapping(method = RequestMethod.GET, value = "/{idUser}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getProfile(@PathVariable Long idUser){
        logger.info("GET");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("toUser", userService.findByIdUser(idUser));
        result.put("lastTransactions", transactionService.findByToUser(idUser));
        result.put("works", workService.findByIdUser(idUser));
        return result;
    }
}



