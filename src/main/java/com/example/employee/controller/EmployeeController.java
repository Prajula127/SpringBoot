/*
 * You can use the following import statements
 *
 * 
 */

// Write your code here
package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeH2Service;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeH2Service employeeService;
    
    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp) {
        return employeeService.addEmployee(emp);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") int employeeId,@RequestBody Employee emp) {
        return employeeService.updateEmployee(employeeId, emp);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}