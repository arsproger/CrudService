package com.example.crudservice.controllers;

import com.example.crudservice.dto.OrganizationDto;
import com.example.crudservice.mappers.OrganizationMapper;
import com.example.crudservice.services.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;
    private final OrganizationMapper mapper;

    @PostMapping
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organization) {
        OrganizationDto createdOrganization = mapper.convertToDto(
                organizationService.createOrganization(mapper.convertToEntity(organization)));
        if (createdOrganization != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrganization);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public List<OrganizationDto> getAllOrganizations() {
        return organizationService.getAllOrganizations()
                .stream().map(mapper::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDto> getOrganizationById(@PathVariable Long id) {
        OrganizationDto organization = mapper.convertToDto(
                organizationService.getOrganizationById(id));
        if (organization != null) {
            return ResponseEntity.ok(organization);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDto> updateOrganization(@PathVariable Long id,
                                                              @RequestBody OrganizationDto organization) {
        OrganizationDto updatedOrganization = mapper.convertToDto(
                organizationService.updateOrganization(id, mapper.convertToEntity(organization)));
        if (updatedOrganization != null) {
            return ResponseEntity.ok(updatedOrganization);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long id) {
        boolean deleted = organizationService.deleteOrganization(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
