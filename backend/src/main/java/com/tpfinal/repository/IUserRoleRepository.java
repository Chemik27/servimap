package com.tpfinal.repository;

import com.tpfinal.domain.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRoleRepository extends CrudRepository<UserRole, Long> {
    @Query("select r.role from UserRole r where r.idUser = :idUser")
    public List<String> findRoleByIdUser(@Param("idUser") Long idUser);
}
