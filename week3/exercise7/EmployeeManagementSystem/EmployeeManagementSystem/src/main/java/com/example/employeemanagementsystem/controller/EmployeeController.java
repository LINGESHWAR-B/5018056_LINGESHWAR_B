package com.example.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    // Other CRUD methods ...

    // Pagination and sorting endpoint
    @GetMapping("/paginated")
    public Page<Employee> getEmployeesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findAll(pageable);
    }

    // Pagination and sorting by department ID endpoint
    @GetMapping("/department/{departmentId}/paginated")
    public Page<Employee> getEmployeesByDepartmentPaginated(
            @PathVariable Long departmentId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findByDepartmentId(departmentId, pageable);
    }

    // Sorting by department ID endpoint
    @GetMapping("/department/{departmentId}/sorted")
    public List<Employee> getEmployeesByDepartmentSorted(
            @PathVariable Long departmentId,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return employeeRepository.findEmployeesByDepartmentId(departmentId, sort);
    }
}
