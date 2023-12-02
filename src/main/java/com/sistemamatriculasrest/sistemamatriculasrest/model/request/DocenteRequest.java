package com.sistemamatriculasrest.sistemamatriculasrest.model.request;

import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
public class DocenteRequest {
    private Integer iddocente;
    private String nomdocente;
    private String email;
    private Boolean activo;
    private Date fechacrea;
}
