package com.tpfinal.domain;

import javax.persistence.*;

@Entity
@Table(name = "district")
public class District {

    private Long idDistrict;
    private String name;
    private Long postalCode;

    public District(String name, Long postalCode) {
        this.name = name;
        this.postalCode = postalCode;
    }

    public District() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_district")
    public Long getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(Long idDistrict) {
        this.idDistrict = idDistrict;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="postal_code")
    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }
}
