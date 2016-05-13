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
    private Long toUser;
    private Long fromUser;
    private Long idState;

    public Transaction(Date creationDate, Long toUser, Long fromUser, Long idState) {
        this.creationDate = creationDate;
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

    @Column(name = "to_user")
    public Long getToUser() {
        return toUser;
    }

    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    @Column(name = "from_user")
    public Long getFromUser() {
        return fromUser;
    }

    public void setFromUser(Long fromUser) {
        this.fromUser = fromUser;
    }

    @Column(name = "id_state")
    public Long getIdState() {
        return idState;
    }

    public void setIdState(Long idState) {
        this.idState = idState;
    }
}
