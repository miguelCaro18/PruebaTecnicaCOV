package com.covinoc.pruebacovi.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CatchExceptionHandler {

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<?> alreadyExistException(AlreadyExistException ex, WebRequest request) {
        ResponseError responseError = new ResponseError(ex.getMessage(), HttpStatus.CONFLICT,"/api/user");
        return new ResponseEntity<>(responseError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<?> commonException(CommonException ex, WebRequest request) {
        System.out.println(ex.getErrorStatus().getReasonPhrase());
        ResponseError responseError = new ResponseError(ex.getMessage(), ex.getErrorStatus(),ex.getPath());
        return new ResponseEntity<>(responseError, ex.getErrorStatus());
    }
}
