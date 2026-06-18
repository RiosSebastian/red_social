package com.example.ApisRest.servis.impl;

import com.example.ApisRest.dto.PublicacionDto;
import com.example.ApisRest.dto.PublicacionRespuesta;
import com.example.ApisRest.entity.Publicacion;
import com.example.ApisRest.exception.RecursoNotFoundException;
import com.example.ApisRest.repository.PublicacionRepository;
import com.example.ApisRest.servis.PublicacionServis;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacionServisImpl implements PublicacionServis {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto) {
        Publicacion publicacion = mapearEntidad(publicacionDto);
        Publicacion nuevaPublicacion = publicacionRepository.save(publicacion);
        PublicacionDto publicacionRespuesta = mapearDto(nuevaPublicacion);
        return publicacionRespuesta;
    }

    @Override
    public PublicacionRespuesta obtenerTodasLasPublicaciones(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);

        Page<Publicacion> publicaciones = publicacionRepository.findAll(pageable);
        List<Publicacion> ListaDePublicaciones = publicaciones.getContent();
        List<PublicacionDto>contenido = ListaDePublicaciones.stream().map(publicacion -> mapearDto(publicacion)).collect(Collectors.toList());
        PublicacionRespuesta publicacionRespuesta = new PublicacionRespuesta();

        publicacionRespuesta.setContenido(contenido);
        publicacionRespuesta.setNumeroPagina(publicaciones.getNumber());
        publicacionRespuesta.setMadidaPagina(publicaciones.getSize());
        publicacionRespuesta.setTotalDeElementos(publicaciones.getTotalElements());
        publicacionRespuesta.setTotalPaginas(publicaciones.getTotalPages());
        publicacionRespuesta.setUltima(publicaciones.isLast());

        return publicacionRespuesta;
    }

    @Override
    public PublicacionDto obtenerPublicacionPorID(long id) {
        Publicacion publicacion = publicacionRepository.findById(id)
                .orElseThrow(()->new RecursoNotFoundException("Publicacion","id", id));
        return mapearDto(publicacion);
    }


    @Override
    public PublicacionDto actualizarPublicacion(PublicacionDto publicacionDto, long id) {
        Publicacion publicacion = publicacionRepository.findById(id)
                .orElseThrow(()->new RecursoNotFoundException("Publicacion","id", id));

        publicacion.setTitulo(publicacionDto.getTitulo());
        publicacion.setDescripcion(publicacionDto.getDescripcion());
        publicacion.setContenido(publicacionDto.getContenido());

        Publicacion publicacionActualizada = publicacionRepository.save(publicacion);
        return mapearDto(publicacionActualizada);

    }

    @Override
    public void eliminarPublicacion(long id) {
        Publicacion publicacion = publicacionRepository.findById(id)
                .orElseThrow(()->new RecursoNotFoundException("Publicacion","id", id));
        publicacionRepository.delete(publicacion);
    }


    private PublicacionDto mapearDto(Publicacion publicacion){//convierte entidad a DTo
        PublicacionDto  publicacionDto = modelMapper.map(publicacion, PublicacionDto.class);

        return  publicacionDto;
    }

    private Publicacion mapearEntidad(PublicacionDto publicacionDto){//convierte a DTo en entidad
        Publicacion publicacion = modelMapper.map(publicacionDto,Publicacion.class);
        return  publicacion;
    }

}
