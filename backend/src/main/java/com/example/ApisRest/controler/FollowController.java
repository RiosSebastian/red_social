package com.example.ApisRest.controler;

import com.example.ApisRest.dto.FollowStatsDto;
import com.example.ApisRest.servis.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follows")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;

    @PostMapping("/{userId}")
    public ResponseEntity<Void> followUser(@PathVariable Long userId) {

        followService.followUser(userId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> unfollowUser(@PathVariable Long userId) {

        followService.unfollowUser(userId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/stats/{userId}")
    public ResponseEntity<FollowStatsDto> getStats(@PathVariable Long userId) {

        return ResponseEntity.ok(
                followService.getStats(userId)
        );
    }
}