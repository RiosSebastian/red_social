package com.example.ApisRest.servis.impl;

import com.example.ApisRest.servis.UploadFilesServis;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
@Service
public class UploadFilesServisImpl implements UploadFilesServis {
    @Override
    public String handleFileUpload(MultipartFile file) throws Exception {

        try {
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String originalName = file.getOriginalFilename();

            if(!originalName.endsWith(".jpg")&&
               !originalName.endsWith(".jpeg")&&
               !originalName.endsWith(".png")){
                return "Los archivos tienen que tener una extecion JPA, JPEG, PNG";
            }

            String fileExtension = originalName.substring(originalName.lastIndexOf("."));
            String newFileName = fileName + fileExtension;

            File floder = new File("src/main/resources/picture");
            if(!floder.exists()){
                floder.mkdirs();
            }

            Path path = Paths.get("src/main/resources/picture/" + newFileName);
            Files.write(path,bytes);
            return "Carga de archivo exitosa";

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
