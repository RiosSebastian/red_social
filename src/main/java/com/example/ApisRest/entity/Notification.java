package com.example.ApisRest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Notification {

    @Id
    private Long id;

    private String message;

    private boolean read;

    private LocalDateTime createdAt;

    @ManyToOne
    private User user;
}