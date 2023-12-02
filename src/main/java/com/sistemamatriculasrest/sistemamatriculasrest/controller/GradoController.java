package com.sistemamatriculasrest.sistemamatriculasrest.controller;

import com.sistemamatriculasrest.sistemamatriculasrest.exception.ResourceNotFoundException;
import com.sistemamatriculasrest.sistemamatriculasrest.model.bd.Grado;
import com.sistemamatriculasrest.sistemamatriculasrest.service.GradoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/grado")
public class GradoController {

    @Autowired
    private GradoService gradoService;

    @GetMapping("")
    public ResponseEntity<List<Grado>> listaGrados() {
        List<Grado> gradoList = gradoService.listaGrados();
        if (gradoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gradoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grado> obtenerGradoPorId(@PathVariable("id") Integer id) {
        Grado grado = gradoService.obtenerGradoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El grado con el ID " + id + " no existe"));
        return new ResponseEntity<>(grado, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Grado> registrarGrado(@RequestBody Grado grado) {
        Grado nuevoGrado = gradoService.registrarGrado(grado);
        return new ResponseEntity<>(nuevoGrado, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Grado> actualizarGrado(@PathVariable("id") Integer id, @RequestBody Grado gradoActualizado) {
        Grado grado = gradoService.actualizarGrado(id, gradoActualizado);
        return new ResponseEntity<>(grado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarGrado(@PathVariable("id") Integer id) {
        gradoService.eliminarGrado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/nomgrado")
    public ResponseEntity<List<Grado>> obtenerGradosPorNombre(@RequestParam String nomgrado) {
        List<Grado> grados = gradoService.obtenerGradosPorNombre(nomgrado);
        if (grados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(grados, HttpStatus.OK);
    }
}
