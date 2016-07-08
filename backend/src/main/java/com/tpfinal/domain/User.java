package com.tpfinal.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    private Long idUser;
    private String name;
    private String surname;
    private String password;
    private String type;
    private String email;
    private String phone;
    private Long rating;;
    private Long enabled;

    //Transient values
    private String fullName;

    public User(Long idUser, String name, String surname, String password, String type, String email, String phone, Long rating, Long enabled) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.type = type;
        this.email = email;
        this.phone = phone;
        this.rating = rating;
        this.enabled = enabled;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false, updatable = false)
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "id_rating")
    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_rating", nullable = false)
//    public Rating getRating() {
//        return rating;
//    }
//
//    public void setRating(Rating rating) {
//        this.rating = rating;
//    }

    @Column(name = "enabled")
    public Long getEnabled() {
        return enabled;
    }

    public void setEnabled(Long enabled) {
        this.enabled = enabled;
    }

    //Transient Values
    @Transient
    public String getFullName() {
        return this.name + " " + this.surname;
    }

}
