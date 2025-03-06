package com.example.EmployeePayroll.model;

import com.example.EmployeePayroll.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double salary;
    private String department;
    private String gender;       // Added gender
    private String startDate;    // Added startDate

    // Constructor to create Employee from EmployeeDTO
    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
        this.department = employeeDTO.getDepartment();
        this.gender = employeeDTO.getGender();
        this.startDate = employeeDTO.getStartDate();
    }
}
