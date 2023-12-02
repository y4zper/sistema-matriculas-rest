package com.sistemamatriculasrest.sistemamatriculasrest.repository;

import com.sistemamatriculasrest.sistemamatriculasrest.model.bd.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Integer> {
    List<Grado> findByNomgrado(String nomgrado);
}
