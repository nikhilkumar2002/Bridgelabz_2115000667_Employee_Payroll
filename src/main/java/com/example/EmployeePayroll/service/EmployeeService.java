package com.example.EmployeePayroll.service;

import com.example.EmployeePayroll.model.Employee;
import com.example.EmployeePayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        updatedEmployee.setId(id);
        return employeeRepository.save(updatedEmployee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
