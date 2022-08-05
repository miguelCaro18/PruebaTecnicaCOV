package com.covinoc.pruebacovi.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AlreadyExistException extends Exception{
    public AlreadyExistException(String mensaje){
        super(mensaje);
    }
}
