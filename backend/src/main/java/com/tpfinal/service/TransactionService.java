package com.tpfinal.service;

import com.tpfinal.domain.*;
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
        User user = userRepository.findByIdUser(transactionDTO.getToUser());
        User fromUser = userRepository.findByIdUser(transactionDTO.getFromUser());
        Work work = new Work();
        work.setIdWork(transactionDTO.getIdWork());
        transaction.setCreationDate(new Date());
        transaction.setToUser(user.getIdUser());
        transaction.setFromUser(fromUser);
        transaction.setAgreedDate(transactionDTO.getAgreedDate());
        transaction.setState(State.TRX_CREATED);
        transaction.setAddress(transactionDTO.getAddress());
        transaction.setTextProblem(transactionDTO.getTextProblem());

        transaction.setWork(work);
        return transaction;
    }

    public List<Transaction> findByFromUser(Long idUser) {
        return transactionRepository.findTop10ByFromUserIdUserOrderByCreationDateDesc(idUser);
    }

    public List<Transaction> findByInfoToUser(Long idUser){

        return  transactionRepository.findTop10ByToUserOrderByCreationDateDesc(idUser);
    }

    public Transaction findByIdTransaccion(Long idTrx) {
        return transactionRepository.findOne(idTrx);
    }

    public void updateTransactionState(Long idTrx, Long state){
        Transaction transaction = transactionRepository.findOne(idTrx);
        transaction.setState(state);
        transactionRepository.save(transaction);
    }
}
