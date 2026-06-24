package com.example.ApisRest.controler;

import com.example.ApisRest.servis.UploadFilesServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

@RestController
@RequestMapping("/upload")
public class UploadFilesControler {

    @Autowired
    UploadFilesServis uploadFilesServis;


    @PostMapping("/pictures")
    private ResponseEntity<String> uploadfi(@RequestParam("file") MultipartFile file) throws Exception {
        return new ResponseEntity<>(uploadFilesServis.handleFileUpload(file), HttpStatus.OK);
    }



}
