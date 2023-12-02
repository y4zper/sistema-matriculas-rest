package com.sistemamatriculasrest.sistemamatriculasrest.model.request;

import lombok.Data;
import java.util.Date;

@Data
public class MatriculaRequest {
    private Integer idmatricula;
    private Integer idestudiante;
    private Integer idgrado;
    private Date fechamat;
    private Integer estado;
    private String observaciones;
}
