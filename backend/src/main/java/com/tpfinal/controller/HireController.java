/**
 * Created by nico on 30/06/16.
 */
package com.tpfinal.controller;

import com.tpfinal.domain.Transaction;
import com.tpfinal.security.CustomUserDetails;
import com.tpfinal.service.TransactionService;
import com.tpfinal.service.UserService;
import com.tpfinal.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/hire")
public class HireController {

    private static final Logger logger = LoggerFactory.getLogger(HireController.class);
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

//    @RequestMapping(value = "/{idUser}/confirm", method = RequestMethod.POST)
//    public TransactionService createTransaction(@RequestBody Transaction transaction, UriComponentsBuilder ucBuilder) {
///
//        transactionService.save(transaction);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
//        return new TransactionService(headers, HttpStatus.CREATED);
//    }

//      UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String name= user.getUsername();
}
