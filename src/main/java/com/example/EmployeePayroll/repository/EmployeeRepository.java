package com.example.EmployeePayroll.repository;

import com.example.EmployeePayroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
