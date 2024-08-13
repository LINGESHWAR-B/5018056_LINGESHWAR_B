package com.example.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemanagementsystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Derived query method to find employees by name
    List<Employee> findByName(String name);
    
    // Derived query method to find employees by email
    Employee findByEmail(String email);
    
    // Derived query method to find employees by department id
    List<Employee> findByDepartmentId(Long departmentId);
}
