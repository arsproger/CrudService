package com.example.crudservice.services;

import com.example.crudservice.entities.OrganizationFile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OrganizationFileService {
    List<OrganizationFile> getAllOrganizationFiles();

    OrganizationFile getOrganizationFileById(Long id);

    ResponseEntity<String> saveFile(Long organizationId, MultipartFile file);

    void deleteFile(Long fileId);

    List<OrganizationFile> getFilesByOrganization(Long organizationId);
}
