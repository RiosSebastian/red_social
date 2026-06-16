package com.example.ApisRest.controler;

import com.example.ApisRest.dto.UpdateProfileRequest;
import com.example.ApisRest.dto.UserProfileDto;
import com.example.ApisRest.servis.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDto> getUserProfile(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                userService.getProfile(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDto> updateProfile(
            @PathVariable Long id,
            @RequestBody UpdateProfileRequest request
    ) {

        return ResponseEntity.ok(
                userService.updateProfile(id, request)
        );
    }
}