package com.springapi.demoapi.service;

import java.util.List;

import com.springapi.demoapi.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(long id, Employee employee);
    void deleteEmployee(long id);
}
