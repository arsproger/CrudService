package com.example.crudservice.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "organization")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "organization")
    private List<Employee> employees;
    @OneToMany(mappedBy = "organization")
    private List<OrganizationFile> organizationFiles;
}
