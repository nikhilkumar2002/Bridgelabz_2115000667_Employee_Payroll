package com.example.EmployeePayroll.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private String name;
    private double salary;
    private String department;
    private String gender;       // Added gender
    private String startDate;    // Added startDate
}
