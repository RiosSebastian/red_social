package com.example.ApisRest.servis;

import com.example.ApisRest.dto.MediaDto;
import org.springframework.web.multipart.MultipartFile;

public interface MediaService {

    MediaDto uploadMedia(Long publicationId, MultipartFile file) throws Exception;
}