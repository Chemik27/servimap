package com.tpfinal.controller;

import com.tpfinal.domain.QualifyUser;
import com.tpfinal.service.QualifyUserService;
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
 * Created by Chemik on 27/07/2016.
 */
@RestController
@RequestMapping("/qualifyuser")
public class QualifyUserController {


        @Autowired
        QualifyUserService qualifyUserService;

        @Autowired
        UserService userService;
        @Autowired
        TransactionService transactionService;

        private static final Logger logger = LoggerFactory.getLogger(QualifyUserService.class);


        @RequestMapping(method= RequestMethod.POST, value = "/save")
        @ResponseStatus(HttpStatus.OK)
        public void save(@RequestBody QualifyUser qualifyUser){
            logger.info("Info rating:  " + qualifyUser);
            qualifyUserService.save(qualifyUser);
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
