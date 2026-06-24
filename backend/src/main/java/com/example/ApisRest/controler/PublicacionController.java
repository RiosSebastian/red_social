package com.example.ApisRest.controler;

import com.example.ApisRest.dto.PublicacionDto;
import com.example.ApisRest.dto.PublicacionRespuesta;
import com.example.ApisRest.servis.PublicacionServis;
import com.example.ApisRest.util.AppConstantes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {
    @Autowired
    private PublicacionServis publicacionServis;


    @GetMapping
    public PublicacionRespuesta listarPublicaciones(@RequestParam(value = "pageNo", defaultValue = AppConstantes.NUMERO_DE_PAGINA_POR_DEFECTO, required = false)int numeroDePagina,
                                                    @RequestParam(value = "pageSize",defaultValue = AppConstantes.MEDIDA_DE_PAGINA_POR_DEFECTO, required = false)int medidaDePagina,
                                                    @RequestParam(value = "sortBy",defaultValue = AppConstantes.ORDENAR_POR_DEFECTO,required = false)String ordenarPor,
                                                    @RequestParam(value = "sortDir",defaultValue = AppConstantes.ORDENAR_DIRECCION_POR_DEFECTO,required = false)String sortDir){

        return publicacionServis.obtenerTodasLasPublicaciones(numeroDePagina, medidaDePagina, ordenarPor, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionDto>obtenerPublicacionPorId(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(publicacionServis.obtenerPublicacionPorID(id));
    }

    @PostMapping
    public ResponseEntity<PublicacionDto>guardarPublicaciones(@Valid @RequestBody PublicacionDto publicacionDto){
            return new ResponseEntity<>(publicacionServis.crearPublicacion(publicacionDto), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicacionDto> actualizarPublicacion(@Valid @RequestBody PublicacionDto publicacionDto, @PathVariable(name = "id") long id){
        PublicacionDto publicacionRespuesta = publicacionServis.actualizarPublicacion(publicacionDto, id );
        return new ResponseEntity<>(publicacionRespuesta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminarPublicacion(@PathVariable(name = "id") long id) {
        publicacionServis.eliminarPublicacion(id);
        return new ResponseEntity<>("publicacion eliminada con exito", HttpStatus.OK);
    }


}
