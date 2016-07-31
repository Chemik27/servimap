/**
 * Created by nico on 30/06/16.
 */
package com.tpfinal.controller;

import com.tpfinal.domain.State;
import com.tpfinal.domain.Transaction;
import com.tpfinal.domain.Work;
import com.tpfinal.dto.TransactionDTO;
import com.tpfinal.service.TransactionService;
import com.tpfinal.service.UserService;
import com.tpfinal.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @RequestMapping(method = RequestMethod.GET, value = "transaction/{idTrx}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getTransaction(@PathVariable Long idTrx){
        logger.info("GET");

        Transaction trx = transactionService.findByIdTransaccion(idTrx);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("toUser", userService.findByIdUser(trx.getToUser()));
        result.put("lastTransactions", transactionService.findByFromUser(trx.getToUser()));
        result.put("transaction", transactionService.findByInfoToUser(trx.getToUser()));
        result.put("works", workService.findByIdUser(trx.getToUser()));
        result.put("tx", trx);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{idUser}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getProfile(@PathVariable Long idUser){
        logger.info("GET");

        Map<String, Object> result = new HashMap<String, Object>();
        Work work = workService.findByIdWork(idUser);
        result.put("work", work);
        result.put("toUser", userService.findByIdUser(work.getUser().getIdUser()));
//        result.put("lastTransactions", transactionService.findByWork(idUser));
//        result.put("transaction", transactionService.findByInfoToUser(idUser));
        return result;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createTransaction(@RequestBody TransactionDTO transactionDTO) {
        transactionService.save(transactionDTO);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/accept")
    @ResponseStatus(HttpStatus.OK)
    public void acceptTransaction(@RequestBody Long idTrx){
        logger.info("Accept transaction: " + idTrx);
        transactionService.updateTransactionState(idTrx, State.TRX_ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/reject")
    @ResponseStatus(HttpStatus.OK)
    public void rejectTransaction(@RequestBody Long idTrx){
        logger.info("Reject transaction: " + idTrx);
        transactionService.updateTransactionState(idTrx, State.TRX_CANCELED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/finish")
    @ResponseStatus(HttpStatus.OK)
    public void finishTransaction(@RequestBody Long idTrx){
        logger.info("Reject transaction: " + idTrx);
        transactionService.updateTransactionState(idTrx, State.TRX_COMPLETED);
    }

}
