package com.example.crudservice.mappers;

import com.example.crudservice.dto.OrganizationFileDto;
import com.example.crudservice.entities.OrganizationFile;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrganizationFileMapper {
    private final ModelMapper modelMapper;

    public OrganizationFileDto convertToDto(OrganizationFile organizationFile) {
        return modelMapper.map(organizationFile, OrganizationFileDto.class);
    }

    public OrganizationFile convertToEntity(OrganizationFileDto organizationFileDto) {
        return modelMapper.map(organizationFileDto, OrganizationFile.class);
    }

}
