package com.example.crudservice.repositories;

import com.example.crudservice.entities.OrganizationFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationFileRepository extends JpaRepository<OrganizationFile, Long> {
    List<OrganizationFile> findByOrganizationId(Long organizationId);
}
