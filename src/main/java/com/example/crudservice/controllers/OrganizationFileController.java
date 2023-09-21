package com.example.crudservice.controllers;

import com.example.crudservice.dto.OrganizationFileDto;
import com.example.crudservice.mappers.OrganizationFileMapper;
import com.example.crudservice.services.OrganizationFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/organization-files")
@RequiredArgsConstructor
public class OrganizationFileController {
    private final OrganizationFileService organizationFileService;
    private final OrganizationFileMapper mapper;

    @GetMapping
    public ResponseEntity<List<OrganizationFileDto>> getAllOrganizationFiles() {
        List<OrganizationFileDto> organizationFiles = organizationFileService.getAllOrganizationFiles()
                .stream().map(mapper::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(organizationFiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationFileDto> getOrganizationFileById(@PathVariable Long id) {
        OrganizationFileDto organizationFile = mapper.convertToDto(
                organizationFileService.getOrganizationFileById(id));
        return new ResponseEntity<>(organizationFile, HttpStatus.OK);
    }

    @PostMapping("/{organizationId}")
    public ResponseEntity<String> uploadFile(
            @PathVariable Long organizationId,
            @RequestParam("file") MultipartFile file) {
        return organizationFileService.saveFile(organizationId, file);
    }

    @DeleteMapping("/{fileId}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long fileId) {
        organizationFileService.deleteFile(fileId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<OrganizationFileDto>> getFilesByOrganization(
            @PathVariable Long organizationId) {
        List<OrganizationFileDto> organizationFiles =
                organizationFileService.getFilesByOrganization(organizationId)
                        .stream().map(mapper::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(organizationFiles, HttpStatus.OK);
    }

}
