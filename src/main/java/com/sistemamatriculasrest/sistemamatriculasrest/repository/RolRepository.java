package com.sistemamatriculasrest.sistemamatriculasrest.repository;

import com.sistemamatriculasrest.sistemamatriculasrest.model.bd.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends
        JpaRepository<Rol, Integer> {

    Rol findByNomrol(String nombrerol);
}