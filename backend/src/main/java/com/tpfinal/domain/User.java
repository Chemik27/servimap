package com.tpfinal.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    private Long idUser;
    private String name;
    private String surname;
    private Long dni;
    private String email;
    private String phone;
    private String rating;

    //Transient values
    private String fullName;

    public User(String name, String surname, Long dni, String email, String phone, String rating) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
        this.rating = rating;
    }

//    public User(String name, String surname, Long dni, String email, String phone, String version, String idRating) {
//        this.name = name;
//        this.surname = surname;
//        this.dni = dni;
//        this.email = email;
//        this.phone = phone;
//        this.version = version;
//        this.idRating = idRating;
//    }

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

    @Column(name = "dni")
    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
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
    public String getRating() {
        return phone;
    }

    public void setRating(String rating) {
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

    //Transient Values
    @Transient
    public String getFullName() {
        return this.name + " " + this.surname;
    }

}
