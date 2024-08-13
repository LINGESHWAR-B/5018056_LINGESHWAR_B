package com.example.employeemanagementsystem.repository.secondary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemanagementsystem.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    // Derived query method to find departments by name
    Department findByName(String name);
}
