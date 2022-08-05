package com.covinoc.pruebacovi.repository;

import com.covinoc.pruebacovi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}