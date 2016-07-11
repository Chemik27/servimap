package com.tpfinal.controller;

import com.tpfinal.domain.User;
import com.tpfinal.dto.UserDTO;
import com.tpfinal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(method= RequestMethod.POST, value = "/create")
    @ResponseStatus(HttpStatus.OK)
    public User save(@RequestBody UserDTO userDTO ){
        logger.info("Creando usuario: " + userDTO.getEmail());
        return userService.createUser(userDTO);
    }


}
