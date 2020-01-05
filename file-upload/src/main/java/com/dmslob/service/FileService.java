package com.dmslob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

@Service
public class FileService {
    // The Environment object will be used to read parameters from the
    // application.properties configuration file
    @Autowired
    private Environment environment;

    public void save(MultipartFile multipartFile) throws Exception {
        String filename = multipartFile.getOriginalFilename();
        String directory = environment.getProperty("file.paths.uploadedFiles");
        String filepath = Paths.get(directory, filename).toString();

        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(new File(filepath)));
        stream.write(multipartFile.getBytes());
        stream.close();
    }
}
