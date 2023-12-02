package com.sistemamatriculasrest.sistemamatriculasrest.controller;

import com.sistemamatriculasrest.sistemamatriculasrest.exception.ResourceNotFoundException;
import com.sistemamatriculasrest.sistemamatriculasrest.model.bd.Estudiante;
import com.sistemamatriculasrest.sistemamatriculasrest.model.request.EstudianteRequest;
import com.sistemamatriculasrest.sistemamatriculasrest.service.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("")
    public ResponseEntity<List<Estudiante>> listaEstudiantes() {
        List<Estudiante> estudianteList = estudianteService.listaEstudiantes();
        if (estudianteList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(estudianteList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable("id") Integer id) {
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El estudiante con el ID " + id + " no existe"));
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Estudiante> registrarEstudiante(@RequestBody EstudianteRequest estudianteRequest) {
        Estudiante estudiante = convertirAEstudiante(estudianteRequest);
        Estudiante nuevoEstudiante = estudianteService.registrarEstudiante(estudiante);
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable("id") Integer id, @RequestBody EstudianteRequest estudianteRequest) {
        Estudiante oldEstudiante = estudianteService.obtenerEstudiantePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El estudiante con el ID " + id + " no existe"));

        oldEstudiante.setNomestudiante(estudianteRequest.getNomestudiante());
        oldEstudiante.setApeestudiante(estudianteRequest.getApeestudiante());
        oldEstudiante.setEmail(estudianteRequest.getEmail());
        oldEstudiante.setTelefono(estudianteRequest.getTelefono());
        oldEstudiante.setFechanac(estudianteRequest.getFechanac());
        oldEstudiante.setDireccion(estudianteRequest.getDireccion());
        oldEstudiante.setActivo(estudianteRequest.getActivo());

        estudianteService.registrarEstudiante(oldEstudiante);
        return new ResponseEntity<>(oldEstudiante, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable("id") Integer id) {
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El estudiante con el ID " + id + " no existe"));
        estudianteService.eliminarEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/nombreestudiante")
    public ResponseEntity<List<Estudiante>> obtenerEstudiantesPorNombre(@RequestParam String nomestudiante) {
        List<Estudiante> estudiantes = estudianteService.obtenerEstudiantesPorNombre(nomestudiante);
        if (estudiantes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    @GetMapping("/apellidoestudiante")
    public ResponseEntity<List<Estudiante>> obtenerEstudiantesPorApellido(@RequestParam String apeestudiante) {
        List<Estudiante> estudiantes = estudianteService.obtenerEstudiantesPorApellido(apeestudiante);
        if (estudiantes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<Estudiante>> obtenerEstudiantesActivos() {
        List<Estudiante> estudiantes = estudianteService.obtenerEstudiantesActivos();
        if (estudiantes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    private Estudiante convertirAEstudiante(EstudianteRequest estudianteRequest) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNomestudiante(estudianteRequest.getNomestudiante());
        estudiante.setApeestudiante(estudianteRequest.getApeestudiante());
        estudiante.setEmail(estudianteRequest.getEmail());
        estudiante.setTelefono(estudianteRequest.getTelefono());
        estudiante.setFechanac(estudianteRequest.getFechanac());
        estudiante.setDireccion(estudianteRequest.getDireccion());
        estudiante.setActivo(estudianteRequest.getActivo());
        return estudiante;
    }
}
