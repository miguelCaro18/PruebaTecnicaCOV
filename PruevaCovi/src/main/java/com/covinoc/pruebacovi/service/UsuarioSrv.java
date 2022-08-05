package com.covinoc.pruebacovi.service;

import com.covinoc.pruebacovi.dto.RequestNewUser;
import com.covinoc.pruebacovi.entity.Usuario;
import com.covinoc.pruebacovi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSrv {


    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario saveUser(RequestNewUser requestNewUser){
        Usuario u = new Usuario();
        u.setId(requestNewUser.getIdentificacion());
        u.setNombre(requestNewUser.getNombre());
        u.setApellido(requestNewUser.getApellido());
        u.setTelefono(requestNewUser.getTelefono());
        return usuarioRepository.save(u);
        //test
    }

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUserById(String id){
        return usuarioRepository.findById(id);
    }
}
