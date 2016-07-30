package com.tpfinal.controller;

import com.tpfinal.domain.User;
import com.tpfinal.dto.UserDTO;
import com.tpfinal.dto.UserUpdateDTO;
import com.tpfinal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/{idUser}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getProfile(@PathVariable Long idUser){
        logger.info("GET");
        return userService.getProfile(idUser);
    }

    @RequestMapping(method = RequestMethod.PUT, value  ="/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateProfile(@RequestBody User updateUser){

        userService.updateProfile(updateUser);

    }

}
