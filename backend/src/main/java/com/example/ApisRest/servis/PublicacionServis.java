package com.example.ApisRest.servis;

import com.example.ApisRest.dto.PublicacionDto;
import com.example.ApisRest.dto.PublicacionRespuesta;

import java.util.List;

public interface PublicacionServis {

    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto);
    public PublicacionRespuesta obtenerTodasLasPublicaciones(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir);
    public PublicacionDto obtenerPublicacionPorID(long id);
    public PublicacionDto actualizarPublicacion(PublicacionDto publicacionDto, long id);
    public  void eliminarPublicacion(long id);

}
