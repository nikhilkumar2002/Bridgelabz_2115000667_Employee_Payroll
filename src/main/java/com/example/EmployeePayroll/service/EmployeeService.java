package com.example.EmployeePayroll.service;

import com.example.EmployeePayroll.dto.EmployeeDTO;
import com.example.EmployeePayroll.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {

    // In-memory storage for employees (replaces database for now)
    private final List<Employee> employeeList = new ArrayList<>();

    // AtomicLong for generating unique IDs
    private final AtomicLong idCounter = new AtomicLong(1);

    // Get all employees from in-memory list
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Get a single employee by ID from in-memory list
    public Employee getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Add a new employee to in-memory list
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        // Create new Employee object with unique ID and data from DTO
        Employee employee = new Employee(
                idCounter.getAndIncrement(),       // ID
                employeeDTO.getName(),             // Name
                employeeDTO.getSalary(),           // Salary (should be 3rd)
                employeeDTO.getDepartment(),       // Department (should be 4th)
                employeeDTO.getGender(),           // Gender (should be 5th)
                employeeDTO.getStartDate()         // StartDate (should be 6th)
        );

        employeeList.add(employee);  // Add to in-memory list
        return employee;
    }

    // Update existing employee in in-memory list
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = getEmployeeById(id);
        if (existingEmployee != null) {
            // Update fields using data from DTO
            existingEmployee.setName(employeeDTO.getName());
            existingEmployee.setGender(employeeDTO.getGender());
            existingEmployee.setDepartment(employeeDTO.getDepartment());
            existingEmployee.setSalary(employeeDTO.getSalary());
            existingEmployee.setStartDate(employeeDTO.getStartDate());
        }
        return existingEmployee;  // Return updated employee
    }

    // Delete an employee by ID from in-memory list
    public void deleteEmployee(Long id) {
        employeeList.removeIf(employee -> employee.getId().equals(id));
    }
}
