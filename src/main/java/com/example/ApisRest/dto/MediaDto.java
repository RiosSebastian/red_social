package com.example.ApisRest.dto;

import lombok.Data;

@Data
public class MediaDto {

    private Long id;

    private String fileUrl;

    private String mediaType;
}