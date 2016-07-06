package com.tpfinal.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_transaction", unique = true)
    private String idTransaction;
    private Date creationDate;
    private String comment;
    private Integer toUser;
    private Integer fromUser;
    private Integer idState;

    public Transaction(Date creationDate, String comment, Integer toUser, Integer fromUser, Integer idState) {
        this.creationDate = creationDate;
        this.comment = comment;
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.idState = idState;
    }

    public Transaction() {
    }


    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    @Column(name = "creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "to_user")
    public Integer getToUser() {
        return toUser;
    }

    public void setToUser(Integer toUser) {
        this.toUser = toUser;
    }

    @Column(name = "from_user")
    public Integer getFromUser() {
        return fromUser;
    }

    public void setFromUser(Integer fromUser) {
        this.fromUser = fromUser;
    }

    @Column(name = "id_state")
    public Integer getIdState() {
        return idState;
    }

    public void setIdState(Integer idState) {
        this.idState = idState;
    }
}
