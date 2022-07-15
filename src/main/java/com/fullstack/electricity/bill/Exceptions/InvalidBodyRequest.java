package com.fullstack.electricity.bill.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidBodyRequest extends RuntimeException{
    public InvalidBodyRequest(String message){
        super(message);
    }
}
