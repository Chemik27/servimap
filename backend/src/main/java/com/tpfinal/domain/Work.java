package com.tpfinal.domain;

import javax.persistence.*;

@Entity
@Table(name = "work")
public class Work {

    private Long idWork;
    private String name;
    private String description;
    private Category category;
    private User user;
    private Address address;
    private Double price;

    public Work(String name, String description, Category category, User user, Address address, Double price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.user = user;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
