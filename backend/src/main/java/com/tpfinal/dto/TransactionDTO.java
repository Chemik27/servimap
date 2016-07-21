package com.tpfinal.dto;

import com.tpfinal.domain.User;
import com.tpfinal.domain.Work;

import java.util.Date;

/**
 * Created by LENOVO on 08/07/2016.
 */
public class TransactionDTO {

    private Integer idTransaction;
    private Date creationDate;
    private Long toUser;
    private User fromUser;
    private Date agreedDate;
    private Long idWork;

    public Long getIdWork() { return idWork; }

    public void setIdWork(Long idWork) {
        this.idWork = idWork;
    }

    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getToUser() {
        return toUser;
    }

    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public Date getAgreedDate() {
        return agreedDate;
    }

    public void setAgreedDate(Date agreedDate) {
        this.agreedDate = agreedDate;
    }

}
