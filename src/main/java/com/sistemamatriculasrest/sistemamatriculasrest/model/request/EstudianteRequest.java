package com.sistemamatriculasrest.sistemamatriculasrest.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class EstudianteRequest {
    private Integer idestudiante;
    private String nomestudiante;
    private String apeestudiante;
    private String email;
    private String telefono;
    private Date fechanac;
    private String direccion;
    private Boolean activo;
    private Date fechacrea;
}
