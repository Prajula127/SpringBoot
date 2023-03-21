package com.example.employee.repository;
import java.util.ArrayList;

import com.example.employee.model.Employee;

// Write your code here

public interface EmployeeRepository {
    ArrayList<Employee> getEmployees();
    Employee getEmployeeById(int employeeId);
    Employee addEmployee(Employee emp);
    Employee updateEmployee(int employeeId, Employee emp);
    void deleteEmployee(int employeeId);
}