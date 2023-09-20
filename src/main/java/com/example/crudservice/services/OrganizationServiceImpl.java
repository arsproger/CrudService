package com.example.crudservice.services;

import com.example.crudservice.entities.Organization;
import com.example.crudservice.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;

    @Override
    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getOrganizationById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @Override
    public Organization updateOrganization(Long id, Organization organization) {
        if (!organizationRepository.existsById(id)) {
            return null;
        }
        organization.setId(id);
        return organizationRepository.save(organization);
    }

    @Override
    public boolean deleteOrganization(Long id) {
        if (!organizationRepository.existsById(id)) {
            return false;
        }
        organizationRepository.deleteById(id);
        return true;
    }

}