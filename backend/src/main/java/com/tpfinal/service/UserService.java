package com.tpfinal.service;

import com.tpfinal.domain.User;
import com.tpfinal.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public User findByIdUser(Long idUser) {
        return userRepository.findByIdUser(idUser);
    }
}
