package com.tpfinal.repository;

import com.tpfinal.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {

    public List<Transaction> findTop10ByToUserOrderByCreationDateDesc(Long idUser);
}
