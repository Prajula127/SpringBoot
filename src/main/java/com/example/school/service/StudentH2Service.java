package com.example.school.service;

import com.example.school.repository.StudentRepository;
import com.example.school.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.jdbc.core.*;

import java.util.*;

/*
 * You can use the following import statements
 *
 */
// Write your code here
@Service
public class StudentH2Service implements StudentRepository {
    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Student> getStudents() {
        List<Student> stuList = db.query("select * from student", new StudentRowMapper());
        ArrayList<Student> student = new ArrayList<>(stuList);
        return student;
    }

    @Override
    public Student getStudentById(int studentId) {
        try {
            Student student = db.queryForObject("select * from student where studentId = ?", new StudentRowMapper(), studentId);
            return student;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

     @Override
    public Student addStudent(Student students) {
        db.update("insert into student(studentName, gender, standard) values(?,?,?)", students.getStudentName(),students.getGender(),students.getStandard());
        Student student = db.queryForObject("select * from student where studentName=? and standard=?", new StudentRowMapper(), students.getStudentName(), students.getStandard());
        return student;
    }

    @Override
    public String addMoreStudents(List<Student> students) {
        for (Student student : students){
            db.update("insert into student(studentName, gender, standard) values(?,?,?)", student.getStudentName(),student.getGender(),student.getStandard());
        }
        // Student s = db.queryForObject("select * from student where studentName=? and standard=?", new StudentRowMapper(), students.getStudentName(), students.getStandard());
        ArrayList<Student> stu = new ArrayList<>(students);
        String s = String.format("Successfully added %d students", stu.size());
        return s;
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
       if (student.getStudentName() != null) {
        db.update("update student set studentName=? where studentId = ?", student.getStudentName(), studentId);
       }

       if (student.getGender() != null) {
        db.update("update student set gender=? where studentId=?", student.getGender(), studentId);
       }

       if (student.getStandard() != 0) {
        db.update("update student set standard=? where studentId=?", student.getStandard(), studentId);
       }

       return getStudentById(studentId);
    }

    @Override
    public void deleteStudent(int studentId) {
        db.update("delete from student where studentId=?", studentId);
    }
}