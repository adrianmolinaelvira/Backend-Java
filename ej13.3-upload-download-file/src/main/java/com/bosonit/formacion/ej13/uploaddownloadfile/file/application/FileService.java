package com.bosonit.formacion.ej13.uploaddownloadfile.file.application;

import com.bosonit.formacion.ej13.uploaddownloadfile.file.infraestructure.controller.output.OutputFileDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    public void init(String path);

    public void deleteAll(String path);

    public OutputFileDto save(MultipartFile file);

    public Resource getFileByName(String filename);

    public Resource getFileById(Long id);
}
