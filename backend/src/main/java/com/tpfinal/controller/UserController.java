package com.tpfinal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.tpfinal.domain.User;
import com.tpfinal.dto.UserDTO;
import com.tpfinal.service.UserService;
import jdk.nashorn.internal.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    Gson gson = new Gson();

    @RequestMapping(method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(method= RequestMethod.POST, value = "/create")
    @ResponseStatus(HttpStatus.OK)
    public User save(@RequestParam("user") String user , @RequestParam("file") MultipartFile file){
        logger.info("Creando usuario: ");
        return userService.createUser(gson.fromJson(user, UserDTO.class), file);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateProfile(@RequestBody UserDTO userDTO){
        logger.info("Actualizando user");
        userService.updateProfile(userDTO);

    }


}
