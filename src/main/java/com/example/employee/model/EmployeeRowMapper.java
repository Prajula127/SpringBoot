package com.example.employee.model;

/*
 * You can use the following import statements 
 */

 import org.springframework.jdbc.core.RowMapper;
 import java.sql.*;

// Write your code here

public class EmployeeRowMapper implements RowMapper<Employee> {
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(
            rs.getInt("employeeId"),
            rs.getString("employeeName"),
            rs.getString("email"),
            rs.getString("department")
        );
    }
}