package com.example.crudservice.services;

import com.example.crudservice.entities.Organization;

import java.util.List;

public interface OrganizationService {
    Organization createOrganization(Organization organization);
    List<Organization> getAllOrganizations();
    Organization getOrganizationById(Long id);
    Organization updateOrganization(Long id, Organization organization);
    boolean deleteOrganization(Long id);
}