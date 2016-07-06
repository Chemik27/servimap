package com.tpfinal.controller;

import com.tpfinal.domain.Transaction;
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

/**
 * Created by nico on 05/07/16.
 */
@RestController
public class ConfirmController {

        private static final Logger logger = LoggerFactory.getLogger(ConfirmController.class);

        @Autowired
        TransactionService transactionService;



        @RequestMapping(value="/confirm", method = RequestMethod.POST)
        @ResponseStatus(HttpStatus.CREATED)

        public @ResponseBody String createTransaction( @RequestBody Transaction transaction) {
            logger.info("POST");

            transactionService.save(transaction);
            return "error";
        }

//      UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String name= user.getUsername();
    }


