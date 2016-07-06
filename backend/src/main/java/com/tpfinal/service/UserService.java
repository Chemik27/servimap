package com.tpfinal.service;

import com.tpfinal.domain.User;
import com.tpfinal.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public User findByIdUser(Long idUser) {
        return userRepository.findByIdUser(idUser);
    }

    public void createUser(User user){
        user = fillUser(user);
        userRepository.save(user);
    }

    public User fillUser(User user){
        user.setCreationDate(new Date());
        user.setRating("0");
        user.setPassword(codePassword(user.getPassword()));
        user.setEnabled(1L);

        return user;
    }
    public String codePassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

}
