package com.sistemamatriculasrest.sistemamatriculasrest.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grado")
@Data @NoArgsConstructor @AllArgsConstructor
public class Grado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgrado;

    @Column(name = "nomgrado")
    private String nomgrado;
}
