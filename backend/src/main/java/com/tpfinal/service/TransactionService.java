package com.tpfinal.service;

import com.tpfinal.domain.Rating;
import com.tpfinal.domain.Transaction;
import com.tpfinal.dto.TransactionDTO;
import com.tpfinal.repository.ITransactionRepository;
import com.tpfinal.util.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    ITransactionRepository transactionRepository;

    public void save(TransactionDTO transactionDTO){
        Transaction transaction= createTransactionFromDTO(transactionDTO);
        transactionRepository.save(transaction);
    }

    public Transaction createTransactionFromDTO(TransactionDTO transactionDTO){

        Transaction transaction = new Transaction();
        transaction.setCreationDate(new Date());
        transaction.setToUser(transactionDTO.getToUser());
        transaction.setFromUser(transactionDTO.getFromUser());
        transaction.setAgreedDate(transactionDTO.getAgreedDate());
        transaction.setDone(transactionDTO.getDone());

        return transaction;
    }

    public List<Transaction> findByToUser(Long idUser) {
        return transactionRepository.findTop10ByToUserOrderByCreationDateDesc(idUser);
    }
//    public List<Transaction> findByToUserAll(Long idUser) {
//        return transactionRepository.findByToUser(idUser);
//    }
}
