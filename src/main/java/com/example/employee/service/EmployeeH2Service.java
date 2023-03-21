package com.example.employee.service;
/*
 * You can use the following import statements 
 */
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.http.HttpStatus;
 import org.springframework.jdbc.core.JdbcTemplate;
 import org.springframework.stereotype.Service;
 import org.springframework.web.server.ResponseStatusException;
 import java.util.*;

import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeRowMapper;
import com.example.employee.repository.EmployeeRepository;

// Write your code here
@Service
public class EmployeeH2Service implements EmployeeRepository {
    @Autowired
    private JdbcTemplate db;
    
    @Override
    public ArrayList<Employee> getEmployees() {
        List<Employee> empList = db.query("select * from Employeelist", new EmployeeRowMapper());
        ArrayList<Employee> emp = new ArrayList<>(empList);
        return emp;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        try {
            Employee emp = db.queryForObject("select * from Employeelist where employeeId=?", new EmployeeRowMapper(), employeeId);
            return emp;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    
    @Override
    public Employee addEmployee(Employee emp) {
        db.update("insert into Employeelist(employeeName, email, department) values (?,?,?)", emp.getEmployeeName(), emp.getEmail(), emp.getDepartment());
        Employee e = db.queryForObject("select * from Employeelist where employeeName=? and email=?", new EmployeeRowMapper(), emp.getEmployeeName(), emp.getEmail());
        return e;
    }

    @Override
    public Employee updateEmployee(int employeeId, Employee emp) {
        if (emp.getEmployeeName() != null) {
            db.update("update Employeelist set employeeName = ? where employeeId=?" , emp.getEmployeeName(), employeeId);
        }
        if (emp.getEmail() != null) {
            db.update("update Employeelist set email = ? where employeeId = ?", emp.getEmail(), employeeId);
        }
        if (emp.getDepartment() != null) {
            db.update("update Employeelist set department = ? where employeeId = ?",emp.getDepartment(), employeeId);
        }
        
        return getEmployeeById(employeeId);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        db.update("delete from Employeelist where employeeId=?", employeeId);
    }
}
