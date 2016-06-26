package com.tpfinal.repository;

import com.tpfinal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

    public User findByIdUser(Long idUser);
    public User findByEmail(String email);
}
