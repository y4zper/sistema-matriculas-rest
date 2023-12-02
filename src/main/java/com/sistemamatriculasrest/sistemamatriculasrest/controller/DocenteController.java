package com.sistemamatriculasrest.sistemamatriculasrest.controller;

import com.sistemamatriculasrest.sistemamatriculasrest.exception.ResourceNotFoundException;
import com.sistemamatriculasrest.sistemamatriculasrest.model.bd.Docente;
import com.sistemamatriculasrest.sistemamatriculasrest.model.request.DocenteRequest;
import com.sistemamatriculasrest.sistemamatriculasrest.service.DocenteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/docente")
public class DocenteController {

    private DocenteService docenteService;

    @GetMapping("")
    public ResponseEntity<List<Docente>> listaDocentes() {
        List<Docente> docenteList = docenteService.listaDocentes();
        if (docenteList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(docenteList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docente> obtenerDocentePorId(@PathVariable("id") Integer id) {
        Docente docente = docenteService.obtenerDocentePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El docente con el ID " + id + " no existe"));
        return new ResponseEntity<>(docente, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Docente> registrarDocente(@RequestBody DocenteRequest docenteRequest) {
        Docente docente = convertirADocente(docenteRequest);
        Docente nuevoDocente = docenteService.registrarDocente(docente);
        return new ResponseEntity<>(nuevoDocente, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Docente> actualizarDocente(@PathVariable("id") Integer id, @RequestBody DocenteRequest docenteRequest) {
        Docente oldDocente = docenteService.obtenerDocentePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El docente con el ID " + id + " no existe"));
        oldDocente.setNomdocente(docenteRequest.getNomdocente());
        oldDocente.setEmail(docenteRequest.getEmail());
        oldDocente.setActivo(docenteRequest.getActivo());
        docenteService.registrarDocente(oldDocente);
        return new ResponseEntity<>(oldDocente, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable("id") Integer id) {
        Docente docente = docenteService.obtenerDocentePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El docente con el ID " + id + " no existe"));
        docenteService.eliminarDocente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/nombredocente")
    public ResponseEntity<Docente> obtenerDocentePorNombre(@RequestParam String nomdocente) {
        Docente docente = docenteService.obtenerDocentePorNombre(nomdocente);
        if (docente == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(docente, HttpStatus.OK);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<Docente>> obtenerDocentesActivos() {
        List<Docente> docentes = docenteService.obtenerDocentesActivos();
        if (docentes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(docentes, HttpStatus.OK);
    }

    // Método para convertir DocenteRequest a Docente
    private Docente convertirADocente(DocenteRequest docenteRequest) {
        Docente docente = new Docente();
        docente.setNomdocente(docenteRequest.getNomdocente());
        docente.setEmail(docenteRequest.getEmail());
        docente.setActivo(docenteRequest.getActivo());
        docente.setFechacrea(docenteRequest.getFechacrea());
        return docente;
    }
}