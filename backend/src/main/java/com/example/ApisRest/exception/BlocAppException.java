package com.example.ApisRest.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class BlocAppException extends RuntimeException{
    private static final long serialVersionUID = 1l;
    private HttpStatus estado;
    private String mensaje;

    public BlocAppException(HttpStatus estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }


}
