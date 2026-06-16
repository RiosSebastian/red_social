package com.example.ApisRest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Media {

    @Id
    private Long id;

    private String url;

    private String type;
}