package com.example.ApisRest.entity;

import jakarta.persistence.Entity;

@Entity
public class BlockUser {

    private User blocker;

    private User blocked;
}
