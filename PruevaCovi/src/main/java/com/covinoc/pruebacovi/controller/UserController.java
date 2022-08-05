package com.covinoc.pruebacovi.controller;


import com.covinoc.pruebacovi.dto.RequestNewUser;
import com.covinoc.pruebacovi.entity.Usuario;
import com.covinoc.pruebacovi.error.AlreadyExistException;
import com.covinoc.pruebacovi.error.CommonException;
import com.covinoc.pruebacovi.service.UsuarioSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UsuarioSrv usuarioSrv;

    @PostMapping
    public ResponseEntity<?> createUsuario(@Valid @RequestBody RequestNewUser requestNewUser, BindingResult bindingResult) throws AlreadyExistException,CommonException {
        if(bindingResult.hasErrors()){
            StringBuilder errors=new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage());
                errors.append(",");
            }
            errors.deleteCharAt(errors.lastIndexOf(","));
            throw new CommonException(errors.toString(),"/api/user",HttpStatus.BAD_REQUEST);
        }

        if(usuarioSrv.getUserById(requestNewUser.getIdentificacion()).isPresent()){
            throw new AlreadyExistException("Usuario existente");
        }
        return new ResponseEntity<>(usuarioSrv.saveUser(requestNewUser), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<?> listUsuarios(){
        return new ResponseEntity<>(usuarioSrv.getUsuarios(),HttpStatus.ACCEPTED);
    }



}
