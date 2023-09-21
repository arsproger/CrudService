package com.example.crudservice.services;

import com.example.crudservice.entities.Employee;
import com.example.crudservice.entities.Organization;
import com.example.crudservice.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final OrganizationService organizationService;

    @Override
    public Employee createEmployee(Long organizationId, Employee employee) {
        Organization organization = organizationService.getOrganizationById(organizationId);
        employee.setOrganization(organization);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Сотрудник с id " + id + " не найден!"));
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