package com.tpfinal.controller;

import com.tpfinal.domain.Address;
import com.tpfinal.domain.User;
import com.tpfinal.service.AddressService;
import com.tpfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    AddressService addresService;
    @Autowired
    UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/dates")
    public List<Address> getDatesRegister(){
        List<Address> listAddress = addresService.findAll();
        return listAddress;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public @ResponseBody String saveUserRestful(@RequestBody User user ){
        String response = "{\"message\":\"Post With ngResource: The user firstname: " + user.getName() + ",email: "+ user.getEmail()+ ", lastname: " + user.getSurname()+"\"}";
        user.setCreationDate(new Date());
        user.setRating("0");
        userService.createUser(user);
        return response;
    }
}
