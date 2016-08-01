package com.tpfinal.controller;

import com.tpfinal.domain.User;
import com.tpfinal.service.MailService;
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

    MailService mailService = new MailService();
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = {"/recoverPassword"})
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> recoverPassword(@RequestBody String email){
        System.out.println("Controller login" + email);
        String resultado = mailService.sendEmail(email);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("email", resultado);
        return result;
    }

    @RequestMapping(method= RequestMethod.POST, value = "/changePassword")
    @ResponseStatus(HttpStatus.OK)
    public User changePassword(@RequestBody User user){

        System.out.println("Cambiando password del usuario");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        User userAux = userService.findByEmail(user.getEmail());
        userAux.setPassword(user.getPassword());
        userService.changePassword(userAux);

        return new User();
    }
}
