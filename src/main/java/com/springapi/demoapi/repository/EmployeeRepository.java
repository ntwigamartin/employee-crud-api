package com.springapi.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springapi.demoapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
