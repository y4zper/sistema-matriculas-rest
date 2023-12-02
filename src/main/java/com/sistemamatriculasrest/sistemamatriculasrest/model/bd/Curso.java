package com.sistemamatriculasrest.sistemamatriculasrest.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@Data @NoArgsConstructor @AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcurso;

    @Column(name = "nomcurso")
    private String nomcurso;

    @ManyToOne
    @JoinColumn(name = "idgrado")
    @JsonBackReference
    private Grado grado;

    @ManyToOne
    @JoinColumn(name = "iddocente")
    @JsonBackReference
    private Docente docente;
}
