package com.example.ApisRest.servis.impl;

import com.example.ApisRest.dto.RegisterRequest;
import com.example.ApisRest.dto.UpdateProfileRequest;
import com.example.ApisRest.dto.UserProfileDto;
import com.example.ApisRest.entity.User;
import com.example.ApisRest.excepciones.RecursoNotFoundException;
import com.example.ApisRest.repository.UserRepository;
import com.example.ApisRest.servis.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserProfileDto register(RegisterRequest request) {

        if(userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username ya existe");
        }

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setRole("ROLE_USER");

        user.setBio("");

        user.setProfilePicture("");

        user.setCreatedAt(LocalDateTime.now());

        User saved = userRepository.save(user);

        return UserProfileDto.builder()
                .id(saved.getId())
                .username(saved.getUsername())
                .email(saved.getEmail())
                .bio(saved.getBio())
                .profilePicture(saved.getProfilePicture())
                .createdAt(saved.getCreatedAt())
                .build();
    }

    @Override
    public UserProfileDto getProfile(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNotFoundException(
                                "Usuario",
                                "id",
                                id
                        ));

        return mapToDto(user);
    }

    @Override
    public UserProfileDto updateProfile(Long id, UpdateProfileRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNotFoundException(
                                "Usuario",
                                "id",
                                id
                        ));

        user.setBio(request.getBio());

        user.setProfilePicture(
                request.getProfilePicture()
        );

        User updated = userRepository.save(user);

        return mapToDto(updated);
    }
}