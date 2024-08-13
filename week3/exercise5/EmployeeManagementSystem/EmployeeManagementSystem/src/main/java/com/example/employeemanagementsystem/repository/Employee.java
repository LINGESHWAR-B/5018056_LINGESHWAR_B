package com.example.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employeemanagementsystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Using named queries
    @Query(name = "Employee.findByName")
    List<Employee> findByName(@Param("name") String name);
    
    @Query(name = "Employee.findByEmail")
    Employee findByEmail(@Param("email") String email);

    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);
}
