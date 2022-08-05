package com.covinoc.pruebacovi.error;

import org.springframework.http.HttpStatus;

public class CommonException extends Exception{

    private String path;
    private HttpStatus errorStatus;
    public CommonException(String message, String path, HttpStatus errorStatus){
        super(message);
        this.errorStatus=errorStatus;
        this.path=path;
    }

    public String getPath() {
        return path;
    }

    public HttpStatus getErrorStatus() {
        return errorStatus;
    }
}
