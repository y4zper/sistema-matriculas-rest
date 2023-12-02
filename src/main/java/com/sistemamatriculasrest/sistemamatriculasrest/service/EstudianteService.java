package com.sistemamatriculasrest.sistemamatriculasrest.service;

import com.sistemamatriculasrest.sistemamatriculasrest.model.bd.Estudiante;
import com.sistemamatriculasrest.sistemamatriculasrest.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> listaEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante registrarEstudiante(Estudiante estudiante) {
        estudiante.setFechacrea(new Date());
        return estudianteRepository.save(estudiante);
    }

    public Optional<Estudiante> obtenerEstudiantePorId(Integer id) {
        return estudianteRepository.findById(id);
    }

    public void eliminarEstudiante(Integer id) {
        estudianteRepository.deleteById(id);
    }

    public List<Estudiante> obtenerEstudiantesPorNombre(String nomestudiante) {
        return estudianteRepository.findByNomestudiante(nomestudiante);
    }

    public List<Estudiante> obtenerEstudiantesPorApellido(String apeestudiante) {
        return estudianteRepository.findByApeestudiante(apeestudiante);
    }

    public List<Estudiante> obtenerEstudiantesActivos() {
        return estudianteRepository.findByActivoTrue();
    }
}
