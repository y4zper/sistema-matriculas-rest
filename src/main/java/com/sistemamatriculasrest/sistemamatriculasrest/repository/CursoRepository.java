package com.sistemamatriculasrest.sistemamatriculasrest.repository;

import com.sistemamatriculasrest.sistemamatriculasrest.model.bd.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface    CursoRepository extends JpaRepository<Curso, Integer> {
    List<Curso> findByNomcurso(String nomcurso);
    List<Curso> findByGradoIdgrado(Integer idgrado);


}