package com.example.goodread.model;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<Book> {
	
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Book(
				rs.getInt("bookId"),
				rs.getString("bookName"),
				rs.getString("imageUrl")
				);
	}

}
