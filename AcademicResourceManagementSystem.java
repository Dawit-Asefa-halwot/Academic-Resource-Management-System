

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;
public class AcademicResourceManagementSystem {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/university_system";
    // private static final String DB_USER = "root";
    // private static final String DB_PASSWORD = "1234";
    private static Connection connection;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String username = null;  // Declare the username variable outside the block

        try {
            System.out.println("Enter database username:");
            String dbUser = scanner.nextLine();

            System.out.println("Enter database password:");
            String dbPassword = scanner.nextLine();

            connection = DriverManager.getConnection(JDBC_URL, dbUser, dbPassword);

            System.out.println("Are you a student or a teacher? Enter 'student' or 'teacher':");
            String userType = scanner.nextLine();





        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection error");
        } finally {
            // Close the scanner in the finally block to ensure it's always closed
            if (scanner != null) {
                scanner.close();
            }
        }




    }



}
