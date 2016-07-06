package com.tpfinal.service;

import com.tpfinal.domain.Transaction;
import com.tpfinal.repository.ITransactionRepository;
import com.tpfinal.util.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    ITransactionRepository transactionRepository;

    public void save(Transaction transaction){
        transactionRepository.save(transaction);
    }

    public List<Transaction> findByToUser(Long idUser) {
        return transactionRepository.findTop10ByToUserOrderByCreationDateDesc(idUser);
    }
}
