package com.tpfinal.repository;

import com.tpfinal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {

    public User findByIdUser(Long idUser);

    public User findByEmail(String email);

}
