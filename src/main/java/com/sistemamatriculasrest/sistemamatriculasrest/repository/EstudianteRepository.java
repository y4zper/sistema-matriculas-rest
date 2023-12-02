package com.sistemamatriculasrest.sistemamatriculasrest.repository;

import com.sistemamatriculasrest.sistemamatriculasrest.model.bd.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    List<Estudiante> findByNomestudiante(String nomestudiante);
    List<Estudiante> findByApeestudiante(String apeestudiante);
    List<Estudiante> findByActivoTrue();
}
