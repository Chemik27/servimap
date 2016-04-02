package com.tpfinal.domain;

import javax.persistence.*;

@Entity
@Table(name = "work")
public class Work {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idWork;
    private String name;
    private String description;

    public Work(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Work() {
    }

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
}
