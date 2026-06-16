package com.example.ApisRest.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateProfileRequest {

    @Size(max = 500)
    private String bio;

    private String profilePicture;
}