package com.tpfinal.controller;

import com.tpfinal.domain.User;
import com.tpfinal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tino on 21/07/2016.
 */

@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = {"/recoverPassword/{email}"})
    @ResponseStatus(HttpStatus.OK)
        public Map<String, Object> recoverPassword(@PathVariable String email){
        System.out.println("Controller login" + email);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("email", new String("asd"));
        return result;
    }

    @RequestMapping(method= RequestMethod.POST, value = "/changePassword/{user}")
    @ResponseStatus(HttpStatus.OK)
    public User changePassword(@PathVariable User user){
        logger.info("Cambiando password del usuario: ");
        System.out.println("Cambiando password del usuario");
        userService.changePassword(user);

        return new User();
    }
}
