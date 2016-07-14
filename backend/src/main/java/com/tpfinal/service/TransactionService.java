package com.tpfinal.service;

import com.tpfinal.domain.Rating;
import com.tpfinal.domain.Transaction;
import com.tpfinal.domain.User;
import com.tpfinal.dto.TransactionDTO;
import com.tpfinal.repository.ITransactionRepository;
import com.tpfinal.repository.IUserRepository;
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

    @Autowired
    IUserRepository userRepository;

    public void save(TransactionDTO transactionDTO){
        Transaction transaction= createTransactionFromDTO(transactionDTO);
        transactionRepository.save(transaction);
    }

    public Transaction createTransactionFromDTO(TransactionDTO transactionDTO){

        Transaction transaction = new Transaction();
        transaction.setCreationDate(new Date());
        User user = userRepository.findByIdUser(transactionDTO.getToUser());
        transaction.setToUser(user.getIdUser());
        transaction.setFromUser(transactionDTO.getFromUser());
        transaction.setAgreedDate(transactionDTO.getAgreedDate());
        transaction.setDone(transactionDTO.getDone());

        return transaction;
    }

    public List<Transaction> findByFromUser(Long idUser) {
        return transactionRepository.findTop10ByFromUserOrderByCreationDateDesc(idUser);
    }

    public List<Transaction> findByInfoToUser(Long idUser){

        return  transactionRepository.findTop10ByWorkUserIdUserOrderByCreationDateDesc(idUser);
    }
}
