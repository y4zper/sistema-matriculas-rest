package com.sistemamatriculasrest.sistemamatriculasrest.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}