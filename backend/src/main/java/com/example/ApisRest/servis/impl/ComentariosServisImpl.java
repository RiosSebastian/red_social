package com.example.ApisRest.servis.impl;

import com.example.ApisRest.dto.ComentariosDto;
import com.example.ApisRest.entity.Comentarios;
import com.example.ApisRest.entity.Publicacion;
import com.example.ApisRest.entity.User;
import com.example.ApisRest.exception.BlocAppException;
import com.example.ApisRest.exception.RecursoNotFoundException;
import com.example.ApisRest.repository.ComentariosRepository;
import com.example.ApisRest.repository.PublicacionRepository;
import com.example.ApisRest.repository.UserRepository;
import com.example.ApisRest.servis.ComentariosServis;
import com.example.ApisRest.servis.NotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentariosServisImpl implements ComentariosServis {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ComentariosRepository comentariosRepository;
    @Autowired
    private PublicacionRepository publicacionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationService notificationService;

    @Override
    public ComentariosDto crearComentario(long publicacionid, ComentariosDto comentariosDto) {
        String username =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName();

        User user =
                userRepository
                        .findByUsername(username)
                        .orElseThrow();

        Comentarios comentarios = mapearEntidad(comentariosDto);

        Publicacion publicacion = publicacionRepository.findById(publicacionid)
                .orElseThrow(()->new RecursoNotFoundException("Publicacion","id", publicacionid));

        comentarios.setPublicacion(publicacion);

        comentarios.setUser(user);

        Comentarios nuevoComentario =
                comentariosRepository.save(comentarios);

        notificationService.createCommentNotification(
                user,
                publicacion
        );
        return mapearDto(nuevoComentario);
    }

    @Override
    public List<ComentariosDto> obtenerComentariosPorPublicacion(Long publicacionid) {
        List<Comentarios> comentariosPublicacion = comentariosRepository.findByPublicacionId(publicacionid);
        return comentariosPublicacion.stream().map(comentarios -> mapearDto(comentarios)).collect(Collectors.toList());
    }

    @Override
    public ComentariosDto obtenerComentariosPorId(Long publicacionid, Long comentariosId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionid)
                .orElseThrow(()->new RecursoNotFoundException("Publicacion","id", publicacionid));

        Comentarios comentarios = comentariosRepository.findById(comentariosId)
                .orElseThrow(()-> new RecursoNotFoundException("Comentarios","id", comentariosId));

        if(!comentarios.getPublicacion().getId().equals(publicacion.getId())){
            throw new BlocAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicacion");
        }

        return mapearDto(comentarios);

    }

    @Override
    public ComentariosDto ActualizarComentarios(Long publicacionid, Long comentariosId, ComentariosDto solicitudDeComentario) {
        Publicacion publicacion = publicacionRepository.findById(publicacionid)
                .orElseThrow(()->new RecursoNotFoundException("Publicacion","id", publicacionid));

        Comentarios comentarios = comentariosRepository.findById(comentariosId)
                .orElseThrow(()-> new RecursoNotFoundException("Comentarios","id", comentariosId));

        if(!comentarios.getPublicacion().getId().equals(publicacion.getId())){
            throw new BlocAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicacion");
        }

        comentarios.setCuerpo(solicitudDeComentario.getCuerpo());

        Comentarios comentarioActualizado = comentariosRepository.save(comentarios);
        return mapearDto(comentarioActualizado);
    }

    @Override
    public void EliminarComentario(Long publicacionid, Long comentariosId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionid)
                .orElseThrow(()->new RecursoNotFoundException("Publicacion","id", publicacionid));

        Comentarios comentarios = comentariosRepository.findById(comentariosId)
                .orElseThrow(()-> new RecursoNotFoundException("Comentarios","id", comentariosId));

        if(!comentarios.getPublicacion().getId().equals(publicacion.getId())){
            throw new BlocAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicacion");
        }
        comentariosRepository.delete(comentarios);
    }


    private ComentariosDto mapearDto(Comentarios comentarios){//convierte entidad a DTo
        ComentariosDto comentariosDto = modelMapper.map(comentarios, ComentariosDto.class);

        return  comentariosDto;
    }

    private Comentarios mapearEntidad(ComentariosDto comentariosDto){//convierte a DTo en entidad
        Comentarios comentarios = modelMapper.map(comentariosDto, Comentarios.class);

        return  comentarios;
    }
}
