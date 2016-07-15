package com.tpfinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) //404
public class NotFoundException extends RuntimeException {

    private String message;

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message){
        super(message);
        this.message = message;
    }

    public String getNotFoundMessage(){

        return this.message;
    }
}
