package com.example.crudservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private Long id;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String homeAddress;
    private String webpage;
    private String bankDetails;
    private String position;
}
