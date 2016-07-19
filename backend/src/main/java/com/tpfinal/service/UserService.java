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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    AddressService addressService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    WorkService workService;


    @Autowired
    RatingService ratingService;

    public User findByIdUser(Long idUser) {
        return userRepository.findByIdUser(idUser);
    }

    public User createUser(UserDTO userDTO, MultipartFile file){
        User user = createUserFromDTO(userDTO);
        try {
            user.setPhoto(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return userRepository.save(user);
    }

    public User createUserFromDTO(UserDTO userDTO){

        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setType(userDTO.getType());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setCreationDate(new Date());
        user.setPassword(codePassword(userDTO.getPassword()));
        user.setPremium(false);

        Address address = addressService.createAddressFromDTO(userDTO.getStreet(), userDTO.getNumber(), userDTO.getIdDistrict(), null, Address.NEW_ADDRESS);
        user.setIdAddress(address.getIdAddress());
        return user;
    }
    public String codePassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    public Map<String, Object> getProfile(Long idUser) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("user", findByIdUser(idUser));
        result.put("lastTransactions", transactionService.findByFromUser(idUser)); // yo contraté
        result.put("transactions", transactionService.findByInfoToUser(idUser)); // me contrataron
        result.put("works", workService.findByIdUser(idUser));
        result.put("rating", ratingService.getRatingAndComments(idUser));

        return result;
    }
}
