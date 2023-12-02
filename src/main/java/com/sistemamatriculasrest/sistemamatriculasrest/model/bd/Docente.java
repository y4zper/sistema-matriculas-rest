package com.sistemamatriculasrest.sistemamatriculasrest.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "docente")
@Data @NoArgsConstructor @AllArgsConstructor
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddocente;

    @Column(name = "nomdocente")
    private String nomdocente;

    @Column(name = "email")
    private String email;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "fechacrea")
    private Date fechacrea;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Curso> cursos;
}
