package com.sistemamatriculasrest.sistemamatriculasrest.service;

import com.sistemamatriculasrest.sistemamatriculasrest.exception.ResourceNotFoundException;
import com.sistemamatriculasrest.sistemamatriculasrest.model.bd.Grado;
import com.sistemamatriculasrest.sistemamatriculasrest.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradoService {

    @Autowired
    private GradoRepository gradoRepository;

    public List<Grado> listaGrados() {
        return gradoRepository.findAll();
    }

    public Grado registrarGrado(Grado grado) {
        return gradoRepository.save(grado);
    }

    public Optional<Grado> obtenerGradoPorId(Integer id) {
        return gradoRepository.findById(id);
    }

    public void eliminarGrado(Integer id) {
        gradoRepository.deleteById(id);
    }

    public List<Grado> obtenerGradosPorNombre(String nomgrado) {
        return gradoRepository.findByNomgrado(nomgrado);
    }

    public Grado actualizarGrado(Integer id, Grado gradoActualizado) {
        Grado oldGrado = obtenerGradoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El grado con el ID " + id + " no existe"));
        oldGrado.setNomgrado(gradoActualizado.getNomgrado());
        return gradoRepository.save(oldGrado);
    }
}
