package com.example.ApisRest.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotificationDto {

    private Long id;

    private String message;

    private String type;

    private boolean read;

    private LocalDateTime createdAt;
}