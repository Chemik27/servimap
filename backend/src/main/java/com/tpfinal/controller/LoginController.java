package com.tpfinal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tino on 21/07/2016.
 */

@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.POST, value = "/recoverPassword")
    @ResponseStatus(HttpStatus.OK)
    public String recoverPassword(@RequestBody String email){
        System.out.println("Controller login" + email);
        return "El email es";
    }

}
