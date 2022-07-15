package com.fullstack.electricity.bill.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BillNotFoundException extends  RuntimeException {
    public BillNotFoundException(String message){
        super(message);
    }
}
