package com.example.ApisRest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hashtag {

    @Id
    private Long id;

    private String name;
}