package com.example.todo.model;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here



public class TodoRowMapper implements RowMapper<Todo> {
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Todo(
            rs.getInt("id"),
            rs.getString("todo"),
            rs.getString("priority"),
            rs.getString("status")

        );
    }
}