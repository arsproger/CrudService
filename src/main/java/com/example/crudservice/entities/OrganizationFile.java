package com.example.crudservice.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "organization_file")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrganizationFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] fileData;
    
    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;
}
