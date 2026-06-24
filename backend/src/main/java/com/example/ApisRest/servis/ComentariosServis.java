package com.example.ApisRest.servis;

import com.example.ApisRest.dto.ComentariosDto;

import java.util.List;

public interface ComentariosServis {
    public ComentariosDto crearComentario(long publicacionid, ComentariosDto comentariosDto);

    public List<ComentariosDto> obtenerComentariosPorPublicacion(Long publicacionid);

    public ComentariosDto obtenerComentariosPorId(Long publicacionid, Long comentariosId);

    public ComentariosDto ActualizarComentarios(Long publicacionid  , Long comentariosId , ComentariosDto solicitudDeComentario);

    public void EliminarComentario(Long publicacionid  , Long comentariosId);
}
