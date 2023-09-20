package com.example.crudservice.controllers;

import com.example.crudservice.dto.EmployeeDto;
import com.example.crudservice.mappers.EmployeeMapper;
import com.example.crudservice.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper mapper;

    @PostMapping("/{id}")
    public ResponseEntity<EmployeeDto> createEmployee(@PathVariable("id") Long organizationId,
                                                      @RequestBody EmployeeDto employeeDto) {
        EmployeeDto createdEmployee = mapper.convertToDto(
                employeeService.createEmployee(organizationId, mapper.convertToEntity(employeeDto)));
        if (createdEmployee != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(createdEmployee);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees()
                .stream().map(mapper::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto employee = mapper.convertToDto(employeeService.getEmployeeById(id));
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
                                                      @RequestBody EmployeeDto employee) {
        EmployeeDto updatedEmployee = mapper.convertToDto(
                employeeService.updateEmployee(id, mapper.convertToEntity(employee)));
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
