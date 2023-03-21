/*
 * You can use the following import statements
 *
 * 
 * import java.sql.SQLException;
 *
 */
package com.example.movie.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.*;

// Write your code here

public class MovieRowMapper implements RowMapper<Movie> {
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
       return new Movie(rs.getInt("movieId"),
                           rs.getString("movieName"),
                           rs.getString("leadActor")	
                        );
    }
}

