package com.example.EmployeePayroll.controller;

import com.example.EmployeePayroll.dto.EmployeeDTO;
import com.example.EmployeePayroll.model.Employee;
import com.example.EmployeePayroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // GET All Employees
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees()
                .stream()
                .map(emp -> new EmployeeDTO(
                        emp.getName(),
                        emp.getGender(),
                        emp.getDepartment(),
                        emp.getSalary(),
                        emp.getStartDate()
                ))
                .collect(Collectors.toList());
    }

    // GET Employee by ID
    @GetMapping("/get/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        Employee emp = employeeService.getEmployeeById(id);
        return new EmployeeDTO(
                emp.getName(),
                emp.getGender(),
                emp.getDepartment(),
                emp.getSalary(),
                emp.getStartDate()
        );
    }

    // POST Create New Employee
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee emp = new Employee(
                null,
                employeeDTO.getName(),
                employeeDTO.getGender(),
                employeeDTO.getDepartment(),
                employeeDTO.getSalary(),
                employeeDTO.getStartDate()
        );
        Employee savedEmp = employeeService.addEmployee(emp);
        return new EmployeeDTO(
                savedEmp.getName(),
                savedEmp.getGender(),
                savedEmp.getDepartment(),
                savedEmp.getSalary(),
                savedEmp.getStartDate()
        );
    }

    // PUT Update Employee
    @PutMapping("/update/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        Employee emp = new Employee(
                id,
                employeeDTO.getName(),
                employeeDTO.getGender(),
                employeeDTO.getDepartment(),
                employeeDTO.getSalary(),
                employeeDTO.getStartDate()
        );
        Employee updatedEmp = employeeService.updateEmployee(id, emp);
        return new EmployeeDTO(
                updatedEmp.getName(),
                updatedEmp.getGender(),
                updatedEmp.getDepartment(),
                updatedEmp.getSalary(),
                updatedEmp.getStartDate()
        );
    }

    // DELETE Employee
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
