package com.tpfinal.domain;

import javax.persistence.*;
import javax.sound.sampled.BooleanControl;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    private final static String TYPE_WORKER = "proveedor";
    private final static String TYPE_HIRER = "contratista";

    private Long idUser;
    private String name;
    private String surname;
    private String password;
    private String type;
    private String email;
    private String phone;
    private Boolean premium;
    private Address idAddress;
    private byte[] photo;

    //Transient values
    private String fullName;

    public User(Long idUser, String name, String surname, String password, String type, String email, String phone, Boolean premium, Address idAddress) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.type = type;
        this.email = email;
        this.phone = phone;
        this.premium = premium;
        this.idAddress = idAddress;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
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

    @Column(name = "premium")
    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_address", nullable = false)
    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
    }

    @Lob
    @Column(name = "photo", nullable=false)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    //Transient Values
    @Transient
    public String getFullName() {
        return this.name + " " + this.surname;
    }

}
