package com.sistemamatriculasrest.sistemamatriculasrest.service;

import com.sistemamatriculasrest.sistemamatriculasrest.model.bd.Curso;
import com.sistemamatriculasrest.sistemamatriculasrest.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listaCursos() {
        return cursoRepository.findAll();
    }

    public Curso registrarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Optional<Curso> obtenerCursoPorId(Integer id) {
        return cursoRepository.findById(id);
    }

    public void eliminarCurso(Integer id) {
        cursoRepository.deleteById(id);
    }

    public List<Curso> obtenerCursosPorNombre(String nomcurso) {
        return cursoRepository.findByNomcurso(nomcurso);
    }

    public List<Curso> obtenerCursosPorIdGrado(Integer idgrado) {
        return cursoRepository.findByGradoIdgrado(idgrado);
    }

}
