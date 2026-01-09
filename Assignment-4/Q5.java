package assignments.assignment4;

//Write a program to display records of all Students whose semester is 7 and branch is EC.
import java.sql.*;

public class Q5 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "Ansh$ag04$"
            );

            String query =
                    "SELECT * FROM Students " +
                    "WHERE semester = 7 AND branch = 'EC'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("branch") + " " +
                        rs.getInt("semester") + " " +
                        rs.getFloat("percentage") + " " +
                        rs.getInt("year_of_passing")
                );
            }

            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}