package com.tpfinal.controller;

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

    @RequestMapping(method = RequestMethod.POST, value = {"/recoverPassword"})
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> recoverPassword(@RequestBody String email){
        System.out.println("Controller login" + email);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("email", new String("asd"));
        return result;
    }

}
