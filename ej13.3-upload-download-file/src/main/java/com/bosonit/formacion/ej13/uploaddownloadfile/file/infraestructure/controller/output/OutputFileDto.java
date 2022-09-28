package com.bosonit.formacion.ej13.uploaddownloadfile.file.infraestructure.controller.output;

import com.bosonit.formacion.ej13.uploaddownloadfile.file.domain.File;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OutputFileDto {

    Long id;
    String metadata;
    String name;
    LocalDateTime upload_date;

    public OutputFileDto(File file){
        setId(file.getId());
        setMetadata(file.getMetadata());
        setName(file.getName());
        setUpload_date(file.getUpload_date());
    }
}
