package com.example.crudservice.services;

import com.example.crudservice.entities.Employee;
import com.example.crudservice.entities.Organization;
import com.example.crudservice.repositories.EmployeeRepository;
import com.example.crudservice.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final OrganizationRepository organizationRepository;

    @Override
    public Employee createEmployee(Long organizationId, Employee employee) {
        Organization organization = organizationRepository.findById(organizationId).orElseThrow(
                () -> new EntityNotFoundException("Организация с id " + organizationId + " не найдена!"));
        employee.setOrganization(organization);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        if (!employeeRepository.existsById(id)) {
            return null;
        }
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }

}