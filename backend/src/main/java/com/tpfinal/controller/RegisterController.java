package com.tpfinal.controller;

import com.tpfinal.domain.Address;
import com.tpfinal.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    AddressService addresService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/dates")
    public List<Address> getDatesRegister(){
        List<Address> listAddress = addresService.findAll();
        return listAddress;
    }
}
