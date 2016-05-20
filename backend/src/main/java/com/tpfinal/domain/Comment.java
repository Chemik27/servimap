package com.tpfinal.domain;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment extends BaseEntity{

    private Long idComment;
    private String text;
    private Long toUser;
    private Long fromUser;

    public Comment(String text, Long toUser, Long fromUser) {
        this.text = text;
        this.toUser = toUser;
        this.fromUser = fromUser;
    }

    public Comment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_comment")
    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    @Column(name="text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name="to_user")
    public Long getToUser() {
        return toUser;
    }

    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    @Column(name="from_user")
    public Long getFromUser() {
        return fromUser;
    }

    public void setFromUser(Long fromUser) {
        this.fromUser = fromUser;
    }
}
