package com.tpfinal.domain;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    private Long idAddress;
    private String street;
    private Long number;
    private Long postalCode;
    private Double latitud;
    private Double length;

    public Address(String street, Long number, Long postalCode, Double latitud, Double length) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.latitud = latitud;
        this.length = length;
    }

    public Address() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "number")
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Column(name = "postal_code")
    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "latitude")
    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    @Column(name = "length")
    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}
