package com.example.crudservice.services;

import com.example.crudservice.entities.Organization;
import com.example.crudservice.entities.OrganizationFile;
import com.example.crudservice.repositories.OrganizationFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationFileServiceImpl implements OrganizationFileService {
    private final OrganizationFileRepository organizationFileRepository;
    private final OrganizationService organizationService;

    @Override
    public List<OrganizationFile> getAllOrganizationFiles() {
        return organizationFileRepository.findAll();
    }

    @Override
    public OrganizationFile getOrganizationFileById(Long id) {
        return organizationFileRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Файл с id " + id + " не найден!"));
    }

    @Override
    @Transactional
    public ResponseEntity<String> saveFile(Long organizationId, MultipartFile file) {
        Organization organization = organizationService.getOrganizationById(organizationId);
        try {
            OrganizationFile organizationFile = OrganizationFile.builder()
                    .fileName(file.getOriginalFilename())
                    .fileType(file.getContentType())
                    .fileData(file.getBytes())
                    .organization(organization)
                    .build();
            organizationFileRepository.save(organizationFile);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("File upload failed: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteFile(Long fileId) {
        organizationFileRepository.deleteById(fileId);
    }

    @Override
    public List<OrganizationFile> getFilesByOrganization(Long organizationId) {
        return organizationFileRepository.findByOrganizationId(organizationId);
    }

}
