package com.example.ApisRest.dto;

import lombok.Data;

import java.util.List;
@Data
public class PublicacionRespuesta {
    private List<PublicacionDto> contenido;
    private int numeroPagina;
    private int madidaPagina;
    private long totalDeElementos;
    private int totalPaginas;
    private boolean ultima;
}
