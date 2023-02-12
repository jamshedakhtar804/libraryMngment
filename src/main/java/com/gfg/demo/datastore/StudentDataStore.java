package com.gfg.demo.datastore;

import com.gfg.demo.database.ConnectionManager;
import com.gfg.demo.model.Student;

import java.awt.print.Book;
import java.sql.*;

import static com.gfg.demo.database.ConnectionManager.getConnection;

public class StudentDataStore {
    private static final String INSERT_STUDENT="INSERT INTO student(name, contact, branch, password) VALUES(";
    private static Connection con= getConnection();

    public static void addNewStudent(Student student){
        try {
            PreparedStatement ps=con.prepareStatement(
                    "INSERT INTO student(name, contact, branch, password) VALUES(?,?,?,?)");
            ps.setString(1, student.getName());
            ps.setString(2, student.getContact());
            ps.setString(3, student.getBranch());
            ps.setString(4, student.getPassword());

            // call executeUpdate to execute our sql update statement and returns number of rows affected
            int updateCount = ps.executeUpdate();

            if(updateCount>0){
                System.out.println("student inserted successfully");
            }else{
                System.out.println("failed to insert");
            }

            //step5 close the connection object
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }

    public static void main(String[] args) {
        Student s1 = Student.builder()
                .name("Shubham")
                .branch("CS")
                .password("test")
                .contact("9151269200")
                .build();

        addNewStudent(s1);
    }
}
