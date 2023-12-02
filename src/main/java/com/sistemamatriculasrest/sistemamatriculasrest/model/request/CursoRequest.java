package com.sistemamatriculasrest.sistemamatriculasrest.model.request;

import lombok.Data;

@Data
public class CursoRequest {
    private Integer idcurso;
    private String nomcurso;
    private Integer idgrado;
    private Integer iddocente;
}