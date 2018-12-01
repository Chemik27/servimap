package com.tpfinal.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {

    private Long idTransaction;
    private Date creationDate;
    private Long toUser; // proveedor
    private User fromUser; //usuario
    private Date agreedDate;
    private Long state;
    private Work work;
    private String textProblem;
    private String address;
    private String rejection;

    public Transaction(Date creationDate, Long toUser, User fromUser,Date agreedDate,Long state, Work work,String address, String rejection) {

        this.creationDate = creationDate;
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.agreedDate= agreedDate;
        this.state = state;
        this.work = work;
        this.textProblem = textProblem;
        this.address = address;
        this.rejection = rejection;
    }

    public Transaction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction", nullable = false, updatable = false)
    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    @Column(name = "creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "to_user")
    public Long getToUser() {
        return toUser;
    }

    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_user", nullable = false)
    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    @Column(name="agreed_date")
    public Date getAgreedDate() {
        return agreedDate;
    }

    public void setAgreedDate(Date agreedDate) {
        this.agreedDate = agreedDate;
    }

    @Column(name="state")
    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "work", nullable = false)
    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Column(name="address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name="text_problem")
    public String getTextProblem() {
        return textProblem;
    }

    public void setTextProblem(String textProblem) {
        this.textProblem = textProblem;
    }

    @Column(name="rejection")
    public String getRejection() {
        return rejection;
    }

    public void setRejection(String rejection) {
        this.rejection = rejection;
    }
}
