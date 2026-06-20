package com.example.ApisRest.controler;

import com.example.ApisRest.dto.MediaDto;
import com.example.ApisRest.servis.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @PostMapping(value = "/{publicationId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MediaDto> upload(@PathVariable Long publicationId, @RequestParam MultipartFile file) throws Exception {

        return ResponseEntity.ok(
                mediaService.uploadMedia(
                        publicationId,
                        file
                )
        );
    }

    @PostMapping("/{publicationId}/multiple")
    public ResponseEntity<List<MediaDto>>
    uploadMultiple(@PathVariable Long publicationId, @RequestParam MultipartFile... files){


        return ResponseEntity.ok(
                    mediaService.uploadMedia(
                            publicationId,
                            files
                    ));
    }
}
