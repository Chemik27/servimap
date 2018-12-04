package com.tpfinal.service;

import com.tpfinal.domain.*;
import com.tpfinal.dto.RejectDTO;
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

    @Autowired
    MailService mailService;

    public void save(TransactionDTO transactionDTO){
        Transaction transaction= createTransactionFromDTO(transactionDTO);
        transactionRepository.save(transaction);
        mailService.newTransaction(transaction);
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
        if(state.equals(State.TRX_ACCEPTED))
            mailService.confirmService(transaction);
    }

    public void rejectTransaction(RejectDTO rejectDTO, Long state) {
        Transaction transaction = transactionRepository.findOne(rejectDTO.getIdTrx());
        transaction.setState(state);
        transaction.setRejection(rejectDTO.getRejection());
        transactionRepository.save(transaction);
        mailService.rejectService(transaction);
    }
}
