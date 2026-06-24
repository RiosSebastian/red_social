package com.example.ApisRest.dto;

import com.example.ApisRest.entity.Comentarios;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublicacionDto {

    private Long id;

    private String titulo;

    private String descripcion;

    private String contenido;

    private List<MediaDto> medias;
}
