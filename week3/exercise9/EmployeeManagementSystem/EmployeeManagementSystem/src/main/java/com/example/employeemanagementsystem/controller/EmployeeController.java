package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.dto.EmployeeDTO;
import com.example.employeemanagementsystem.projection.EmployeeProjection;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Other CRUD methods ...

    // Interface-based projection endpoint
    @GetMapping("/department/{departmentId}/projection")
    public List<EmployeeProjection> getEmployeesByDepartmentProjection(@PathVariable Long departmentId) {
        return employeeRepository.findEmployeesByDepartmentId(departmentId);
    }

    // Class-based projection endpoint
    @GetMapping("/department/{departmentId}/dto")
    public List<EmployeeDTO> getEmployeesByDepartmentDTO(@PathVariable Long departmentId) {
        return employeeRepository.findEmployeeDTOByDepartmentId(departmentId);
    }
}
