package assignments.assignment4;

//Write a program to increase 5% to percentage of all Students whose branch is CSE.
import java.sql.*;

public class Q3 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "Ansh$ag04$"
            );

            String query =
                    "UPDATE Students " +
                    "SET percentage = percentage + (percentage * 0.05) " +
                    "WHERE branch = 'CSE'";

            Statement st = con.createStatement();
            int rows = st.executeUpdate(query);

            System.out.println(rows + " record(s) updated");

            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}