package com.springapi.demoapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springapi.demoapi.exception.ResourceNotFoundException;
import com.springapi.demoapi.model.Employee;
import com.springapi.demoapi.repository.EmployeeRepository;
import com.springapi.demoapi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("employee", "id", id));
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("employee", "id", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
        employeeRepository.deleteById(id);
        
    }

    
    
    
}
