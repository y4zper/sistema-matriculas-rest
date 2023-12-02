package com.sistemamatriculasrest.sistemamatriculasrest.controller;

import com.sistemamatriculasrest.sistemamatriculasrest.exception.ResourceNotFoundException;
import com.sistemamatriculasrest.sistemamatriculasrest.model.bd.Curso;
import com.sistemamatriculasrest.sistemamatriculasrest.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/curso")
public class CursoController {

    private CursoService cursoService;

    @GetMapping("")
    public ResponseEntity<List<Curso>> listaCursos() {
        List<Curso> cursoList = cursoService.listaCursos();
        if (cursoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cursoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable("id") Integer id) {
        Curso curso = cursoService.obtenerCursoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El curso con el ID " + id + " no existe"));
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Curso> registrarCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.registrarCurso(curso);
        return new ResponseEntity<>(nuevoCurso, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable("id") Integer id, @RequestBody Curso curso) {
        Curso oldCurso = cursoService.obtenerCursoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El curso con el ID " + id + " no existe"));
        oldCurso.setNomcurso(curso.getNomcurso());
        cursoService.registrarCurso(oldCurso);
        return new ResponseEntity<>(oldCurso, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable("id") Integer id) {
        Curso curso = cursoService.obtenerCursoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El curso con el ID " + id + " no existe"));
        cursoService.eliminarCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/nombrecurso")
    public ResponseEntity<List<Curso>> obtenerCursosPorNombre(@RequestParam String nomcurso) {
        List<Curso> cursos = cursoService.obtenerCursosPorNombre(nomcurso);
        if (cursos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @GetMapping("/idgrado")
    public ResponseEntity<List<Curso>> obtenerCursosPorIdGrado(@RequestParam Integer idgrado) {
        List<Curso> cursos = cursoService.obtenerCursosPorIdGrado(idgrado);
        if (cursos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
}
