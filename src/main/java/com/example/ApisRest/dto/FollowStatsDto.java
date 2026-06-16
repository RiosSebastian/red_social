package com.example.ApisRest.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FollowStatsDto {

        private Long userId;

        private long followers;

        private long following;
    }

