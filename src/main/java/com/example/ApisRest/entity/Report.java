package com.example.ApisRest.entity;

import jakarta.persistence.Entity;

@Entity
public class Report {

    private User reporter;

    private Publicacion publicacion;

    private String reason;
}