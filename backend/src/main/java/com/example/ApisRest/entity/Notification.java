package com.example.ApisRest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    @Id
    private Long id;

    @ManyToOne
    private User recipient;

    @ManyToOne
    private User sender;

    private String type;

    private String message;

    private boolean read;

    private LocalDateTime createdAt;
}