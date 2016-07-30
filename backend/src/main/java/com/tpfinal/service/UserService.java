package com.tpfinal.service;

import com.tpfinal.domain.Address;
import com.tpfinal.domain.User;
import com.tpfinal.dto.UserDTO;
import com.tpfinal.dto.UserUpdateDTO;
import com.tpfinal.exception.BadRequestException;
import com.tpfinal.repository.IAddressRepository;
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
    IAddressRepository addressRepository;

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

        User existUser = userRepository.findByEmail(userDTO.getEmail());
        if(existUser != null)
            throw new BadRequestException("Usuario existente");

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
        user.setIdAddress(address);
        return user;
    }

    public User updateUserFromDTO(UserUpdateDTO userUpdateDTO){

        User user = new User();
        user = userRepository.findByIdUser(userUpdateDTO.getIdUser());

        user.setName(userUpdateDTO.getName());
        user.setSurname(userUpdateDTO.getSurname());
        user.setEmail(userUpdateDTO.getEmail());
        user.setPhone(userUpdateDTO.getPhone());
        user.setPassword(codePassword(userUpdateDTO.getPassword()));

//        Address address = addressService.createAddressFromDTO(userUpdateDTO.getStreet(), userUpdateDTO.getNumber(), userUpdateDTO.getIdDistrict(), null, Address.NEW_ADDRESS);
//        user.setIdAddress(address);
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

    public void updateProfile(User updateUser) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = userRepository.findByIdUser(updateUser.getIdUser());
        String passwords = updateUser.getPassword();
        String[] parts = passwords.split(",");
        String currentPassword = parts[0];
        String newPassword = parts[1];

        updateUser.setPassword(user.getPassword());

        if(encoder.matches(currentPassword, user.getPassword())){

            if(!newPassword.equals("")){
                updateUser.setPassword(codePassword(newPassword));

            }else{
                updateUser.setPassword(codePassword(user.getPassword()));
            }
        }

        userRepository.save(updateUser);

         //Address address = addressRepository.findOne(user.getIdAddress().getIdAddress());
        //address.setStreet(updateUser.getStreet());
        //address.setNumber(updateUser.getNumber());
        //address.setDistrict(updateUser.getIdDistrict());
        //addressRepository.save(address);

    }
}
