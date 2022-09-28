package com.bosonit.formacion.ej13.uploaddownloadfile.file.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class File {

    @Id
    @GeneratedValue
    Long id;

    @Column
    String metadata;

    @Column
    String name;

    @Column
    LocalDateTime upload_date;

    public File(String metadata, String name, LocalDateTime upload_date){
        this.name = name;
        this.metadata = metadata;
        this.upload_date = upload_date;
    }
}
