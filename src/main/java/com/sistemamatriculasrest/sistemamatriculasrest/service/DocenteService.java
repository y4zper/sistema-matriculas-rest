package com.sistemamatriculasrest.sistemamatriculasrest.service;

import com.sistemamatriculasrest.sistemamatriculasrest.model.bd.Docente;
import com.sistemamatriculasrest.sistemamatriculasrest.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> listaDocentes() {
        return docenteRepository.findAll();
    }

    public Docente registrarDocente(Docente docente) {
        docente.setFechacrea(new Date());
        return docenteRepository.save(docente);
    }

    public Optional<Docente> obtenerDocentePorId(Integer id) {
        return docenteRepository.findById(id);
    }

    public void eliminarDocente(Integer id) {
        docenteRepository.deleteById(id);
    }

    public Docente obtenerDocentePorNombre(String nomdocente) {
        return docenteRepository.findByNomdocente(nomdocente);
    }

    public List<Docente> obtenerDocentesActivos() {
        return docenteRepository.findByActivoTrue();
    }
}
