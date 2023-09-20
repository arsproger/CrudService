package com.example.crudservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrganizationDto {
    private Long id;
    private String ownershipForm;
    private String legalForm;
    private String name;
    private String leaderName;
    private String fax;
    private String phone;
    private String website;
    private String login;
    private String licenseNumber;
    private LocalDate licenseDate;
    private String certificateNumber;
    private LocalDate certificateDate;
    private String address;
}
