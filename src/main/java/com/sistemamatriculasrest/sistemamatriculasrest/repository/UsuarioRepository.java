package com.sistemamatriculasrest.sistemamatriculasrest.repository;

import com.sistemamatriculasrest.sistemamatriculasrest.model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends
        JpaRepository<Usuario, Integer>{

    Usuario findByNomusuario(String nomusuario);
}
