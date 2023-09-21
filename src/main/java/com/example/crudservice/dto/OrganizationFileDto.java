package com.example.crudservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationFileDto {
    private String fileName;
    private String fileType;
    private byte[] fileData;
}
