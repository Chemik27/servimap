package com.tpfinal.repository;

import com.tpfinal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends CrudRepository<User, Long> {

    public User findByIdUser(Long idUser);

    public User findByEmail(String email);

    @Modifying
    @Query("UPDATE User u SET u.password = :password WHERE  u.email = :email")
    public void updatePassword(@Param("password") String password, @Param("email") String email);

}
