package com.tpfinal.domain;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    private Long idAddress;
    private String street;
    private Long number;
    private District district;

    public final static Long NO_WORK_ADDRESS = 1L;
    public final static Long SAME_RECIDENTIAL_ADDRESS = 2L;
    public final static Long NEW_ADDRESS = 3L;

    public Address(String street, Long number, District district) {
        this.street = street;
        this.number = number;
        this.district = district;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_district")
    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
