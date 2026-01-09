package assignments.assignment4;

//Write a program to create a table called Students using JDBC and insert records into it.
import java.sql.*;

public class Q2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "Ansh$ag04$"
            );

            Statement st = con.createStatement();

            // Create Table
            String createTable =
                    "CREATE TABLE IF NOT EXISTS Students (" +
                    "id INT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "branch VARCHAR(20)," +
                    "semester INT," +
                    "percentage FLOAT," +
                    "year_of_passing INT)";

            st.execute(createTable);

            // Insert Records
            String insert =
                    "INSERT INTO Students VALUES " +
                    "(1,'Ansh','CSE',7,78.5,2024)," +
                    "(2,'Ravi','EC',7,72.0,2025)," +
                    "(3,'Amit','Civil',6,69.0,2024)";

            st.executeUpdate(insert);

            System.out.println("Table created & Records inserted");

            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}