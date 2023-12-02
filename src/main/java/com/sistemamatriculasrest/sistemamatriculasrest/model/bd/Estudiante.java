package com.sistemamatriculasrest.sistemamatriculasrest.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "estudiante")
@Data @NoArgsConstructor @AllArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestudiante;

    @Column(name = "nomestudiante")
    private String nomestudiante;

    @Column(name = "apeestudiante")
    private String apeestudiante;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fechanac")
    private Date fechanac;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "fechacrea")
    private Date fechacrea;
}
