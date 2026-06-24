package com.example.ApisRest.servis;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFilesServis {

    String handleFileUpload(MultipartFile file) throws Exception;
}
