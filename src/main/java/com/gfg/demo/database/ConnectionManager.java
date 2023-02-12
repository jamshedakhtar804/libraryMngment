package com.gfg.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {

  public static Connection getConnection() {
    try {
      Connection con = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/library", "root", "root");
      return con;
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }
}
/*  public static List<Book> getBooks() {
    List<Book> books = new ArrayList<>();
    try {
      Statement stmt = getConnection();
      //step4 execute query
      ResultSet rs = stmt.executeQuery("select * from book");
      while (rs.next()){
        books.add(Book.builder()
                .bookId(rs.getInt(1))
                .bookName(rs.getString(2))
                .author(rs.getString(3))
                .copies(rs.getInt(4))
            .build());
      }
      System.out.println(books);
      //step5 close the connection object
    }catch (SQLException sqlException){
      System.out.println(sqlException.getMessage());
    }
    return books;
  }

  public static void main(String[] args) {
    getBooks();
  }
}*/
