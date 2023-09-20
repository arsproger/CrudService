package com.example.crudservice.services;

import com.example.crudservice.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Long organizationId, Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employee);
    boolean deleteEmployee(Long id);
}