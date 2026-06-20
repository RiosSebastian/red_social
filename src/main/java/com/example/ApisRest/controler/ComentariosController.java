package com.example.ApisRest.controler;

import com.example.ApisRest.dto.ComentariosDto;
import com.example.ApisRest.servis.ComentariosServis;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ComentariosController {
    @Autowired
    private ComentariosServis comentariosServis;



    @GetMapping("/publicaciones/{publicacionId}/comentarios")
    public List<ComentariosDto>ListarComentariosPorPublicacion(@PathVariable (value = "publicacionId")Long publicacionId){
        return comentariosServis.obtenerComentariosPorPublicacion(publicacionId);
    }

    @GetMapping("/publicaciones/{publicacionId}/comentarios/{Id}")
    public ResponseEntity<ComentariosDto>obtenerComentariosPorId(@PathVariable (value = "publicacionId")Long publicacionId, @PathVariable(value = "Id")Long comentarioId){
        ComentariosDto comentariosDto = comentariosServis.obtenerComentariosPorId(publicacionId,comentarioId);
        return new ResponseEntity<>(comentariosDto,HttpStatus.OK);
    }

    @PostMapping("/publicaciones/{publicacionId}/comentarios")
    public ResponseEntity<ComentariosDto>guardarComentarios( @PathVariable (value = "publicacionId")long publicacionId, @Valid @RequestBody ComentariosDto comentariosDto){
        return new ResponseEntity<>(comentariosServis.crearComentario(publicacionId, comentariosDto), HttpStatus.CREATED);
    }

    @PutMapping("/publicaciones/{publicacionId}/comentarios/{Id}")
    public ResponseEntity<ComentariosDto>actualizarComentario( @PathVariable (value = "publicacionId")Long publicacionId,  @PathVariable(value = "Id")Long comentariosId, @Valid @RequestBody ComentariosDto comentariosDto){
        ComentariosDto comentarioActualizado = comentariosServis.ActualizarComentarios(publicacionId, comentariosId, comentariosDto);
        return new ResponseEntity<>(comentarioActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/publicaciones/{publicacionId}/comentarios/{Id}")
    public ResponseEntity<String>eliminarComentario(@PathVariable (value = "publicacionId")Long publicacionId, @PathVariable(value = "Id")Long comentarioId){
        comentariosServis.EliminarComentario(publicacionId,comentarioId);
        return new ResponseEntity<>("Comentario Eliminado", HttpStatus.OK);
    }
}
