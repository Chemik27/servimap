package com.tpfinal.domain;

import javax.persistence.*;

@Entity
@Table(name="user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUserRole;
    private Long idUser;
    private String role;

    @Column(name="role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name="id_user")
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Column(name="id_user_role")
    public Long getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(Long idUserRole) {
        this.idUserRole = idUserRole;
    }

}