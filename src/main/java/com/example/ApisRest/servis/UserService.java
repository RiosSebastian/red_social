package com.example.ApisRest.servis;

import com.example.ApisRest.dto.RegisterRequest;
import com.example.ApisRest.dto.UpdateProfileRequest;
import com.example.ApisRest.dto.UserProfileDto;

public interface UserService {

    UserProfileDto register(RegisterRequest request);

    UserProfileDto getProfile(Long id);

    UserProfileDto updateProfile(Long id, UpdateProfileRequest request);
}