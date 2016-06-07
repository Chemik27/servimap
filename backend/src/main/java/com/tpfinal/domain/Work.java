package com.tpfinal.domain;

import javax.persistence.*;

@Entity
@Table(name = "work")
public class Work {

    private Long idWork;
    private String name;
    private String description;
    private Category category;
    private Long idUser;
    private Address address;
    private double price;

    public Work(String name, String description, Category category, Long idUser, Address address, double price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.idUser = idUser;
        this.address = address;
        this.price = price;
    }

    public Work() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_work")
    public Long getIdWork() {
        return idWork;
    }

    public void setIdWork(Long idWork) {
        this.idWork = idWork;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "id_user")
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_address", nullable = false)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
