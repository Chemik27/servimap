package com.tpfinal.service;

import com.tpfinal.domain.Address;
import com.tpfinal.domain.Rating;
import com.tpfinal.domain.User;
import com.tpfinal.domain.Work;
import com.tpfinal.dto.UserDTO;
import com.tpfinal.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    private final static String PROVEEDOR = "proveedor";
    private final static String COMPRADOR = "comprador";

    @Autowired
    IUserRepository userRepository;

    @Autowired
    AddressService addressService;

    @Autowired
    RatingService ratingService;

    @Autowired
    WorkService workService;

    public User findByIdUser(Long idUser) {
        return userRepository.findByIdUser(idUser);
    }

    public void createUser(UserDTO userDTO){

        User user = createUserFromDTO(userDTO);
        userRepository.save(user);
    }

    public User createUserFromDTO(UserDTO userDTO){
        Rating rating = ratingService.createNew();

        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setType(userDTO.getType());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setCreationDate(new Date());
        user.setPassword(codePassword(userDTO.getPassword()));
        user.setEnabled(1L);

        Address address = addressService.createFromUser(userDTO);
        user.setIdAddress(address.getIdAddress());
//        }else{
//            TODO CREAR WORK
//            Work work = workService.createFromWorker(userDTO);
//        }

        return user;
    }
    public String codePassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

}
