package com.example.ApisRest.dto;


import lombok.Data;

@Data
public class ComentariosDto {

    private Long id;

    private String username;

    private String profilePicture;

    private String cuerpo;
}
