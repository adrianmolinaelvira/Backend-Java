package com.bosonit.formacion.ej13.uploaddownloadfile.file.infraestructure.controller;

import com.bosonit.formacion.ej13.uploaddownloadfile.file.application.FileService;
import com.bosonit.formacion.ej13.uploaddownloadfile.file.infraestructure.controller.output.OutputFileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload/{type}")
    public ResponseEntity<OutputFileDto> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String type) {

        if(!file.getContentType().split("/")[1].equals(type))
            throw new RuntimeException("Invalid content type");

        return ResponseEntity.status(HttpStatus.OK).body(fileService.save(file));
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<Resource> getFileById(@PathVariable Long id){
        Resource file = fileService.getFileById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/file/name/{name}")
    public ResponseEntity<Resource> getFileByName(@PathVariable String name){
        Resource file = fileService.getFileByName(name);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
