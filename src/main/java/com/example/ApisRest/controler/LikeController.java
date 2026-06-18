package com.example.ApisRest.controler;

import com.example.ApisRest.dto.LikeResponseDto;
import com.example.ApisRest.servis.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/{publicationId}")
    public ResponseEntity<LikeResponseDto>
    likePublication(
            @PathVariable Long publicationId
    ) {

        return ResponseEntity.ok(
                likeService.likePublication(
                        publicationId
                )
        );
    }

    @DeleteMapping("/{publicationId}")
    public ResponseEntity<LikeResponseDto>
    unlikePublication(
            @PathVariable Long publicationId
    ) {

        return ResponseEntity.ok(
                likeService.unlikePublication(
                        publicationId
                )
        );
    }

    @GetMapping("/{publicationId}")
    public ResponseEntity<LikeResponseDto>
    getLikes(
            @PathVariable Long publicationId
    ) {

        return ResponseEntity.ok(
                likeService.getLikes(
                        publicationId
                )
        );
    }
}