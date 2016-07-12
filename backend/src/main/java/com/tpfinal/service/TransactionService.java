package com.tpfinal.service;

import com.tpfinal.domain.Transaction;
import com.tpfinal.domain.User;
import com.tpfinal.dto.TransactionDTO;
import com.tpfinal.repository.ITransactionRepository;
import com.tpfinal.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        transaction.setToUser(transactionDTO.getToUser());
        transaction.setFromUser(transactionDTO.getFromUser());
        transaction.setAgreedDate(transactionDTO.getAgreedDate());
        transaction.setDone(transactionDTO.getDone());

        return transaction;
    }

    public List<Transaction> findByFromUser(Long idUser) {
        return transactionRepository.findTop10ByFromUserOrderByCreationDateDesc(idUser);
    }

    public List<Iterable<User>> findByToUser(Long idUser) {

       List<Long> id_user = new ArrayList();
       List<Iterable<User>> listadeusuarios = new ArrayList<Iterable<User>>();

        // Busco las transaccion del usuario logueado
        List<Transaction> transaction = findByFromUser(idUser);

        // Agarro cada transaccion y tomo el id del proveedor
        for (Transaction i: transaction) {
           //Lista con los id de los usuarios proveedores
           id_user.add(i.getToUser());
           // Busco por cada id encontrado todos los datos del proveedor
           listadeusuarios.add(userRepository.findAll(id_user));
        }
        return  listadeusuarios;
    }
}
