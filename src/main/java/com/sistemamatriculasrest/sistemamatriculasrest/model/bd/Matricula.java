package com.sistemamatriculasrest.sistemamatriculasrest.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "matricula")
@Data @NoArgsConstructor @AllArgsConstructor
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmatricula;

    @ManyToOne
    @JoinColumn(name = "idestudiante")
    @JsonBackReference
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "idgrado")
    @JsonBackReference
    private Grado grado;

    @Column(name = "fechamat")
    private Date fechamat;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "observaciones")
    private String observaciones;
}
