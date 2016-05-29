package com.tpfinal.controller;

import com.tpfinal.service.TransactionService;
import com.tpfinal.service.UserService;
import com.tpfinal.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

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
        result.put("user", userService.findByIdUser(idUser));
        result.put("lastTransactions", transactionService.findByToUser(idUser));
        result.put("works", workService.findByIdUser(idUser));
        return result;
    }
}
