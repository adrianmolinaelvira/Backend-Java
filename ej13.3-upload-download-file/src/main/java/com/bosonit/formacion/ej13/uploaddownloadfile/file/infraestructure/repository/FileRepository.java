package com.bosonit.formacion.ej13.uploaddownloadfile.file.infraestructure.repository;

import com.bosonit.formacion.ej13.uploaddownloadfile.file.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long> {
    Optional<File> findByName(String name);
}
