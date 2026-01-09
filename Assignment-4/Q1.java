package assignments.assignment4;

//Write a program to demonstrate JDBC connection establishment to MySQL. 
//If connections is established then "Connection Successful" message will displayed
//otherwise "Unable to connect" message should be displayed.

import java.sql.*;

public class Q1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "Ansh$ag04$"
            );

            if (con != null) {
                System.out.println("Connection Successful");
            } else {
                System.out.println("Unable to connect");
            }

            con.close();
        }
        catch (Exception e) {
            System.out.println("Unable to connect");
            e.printStackTrace();
        }
    }
}