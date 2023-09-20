package com.example.crudservice.mappers;

import com.example.crudservice.dto.OrganizationDto;
import com.example.crudservice.entities.Organization;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrganizationMapper {
    private final ModelMapper modelMapper;

    public OrganizationDto convertToDto(Organization organization) {
        return modelMapper.map(organization, OrganizationDto.class);
    }

    public Organization convertToEntity(OrganizationDto organizationDto) {
        return modelMapper.map(organizationDto, Organization.class);
    }

}
