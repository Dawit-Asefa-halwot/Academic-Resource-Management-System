
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AcademicResourceManagementSystem {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/university_system";
    // private static final String DB_USER = "root";
    // private static final String DB_PASSWORD = "1234";
    private static Connection connection;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String username = null;  // Declare the username variable outside the block

        try {
            //connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
            System.out.println("Enter database username:");
            String dbUser = scanner.nextLine();

            System.out.println("Enter database password:");
            String dbPassword = scanner.nextLine();

            connection = DriverManager.getConnection(JDBC_URL, dbUser, dbPassword);

            System.out.println("Are you a student or a teacher? Enter 'student' or 'teacher':");
            String userType = scanner.nextLine();

            if ("student".equalsIgnoreCase(userType)) {
                // Student Functionality
                System.out.println("1. Register\n2. See Schedule\n3. See Grade\n4. See Material\nEnter your choice:");
                int studentChoice = scanner.nextInt();

                switch (studentChoice) {
                    case 1:
                        // Register Student
                        System.out.println("Student Registration - Enter your username:");
                        username = scanner.next();
                        System.out.println("Enter your password:");
                        String password = scanner.next();

                        System.out.println("Registration successful!");
                        break;

                    case 2:
                        // See Schedule for Student
                        System.out.println("1. Class Schedule\n2. Assignment Schedule\n3. Exam Schedule\nEnter your choice:");
                        int scheduleType = scanner.nextInt();

                        switch (scheduleType) {
                            case 1:
                                // Display Class Schedule

                                break;

                            case 2:
                                // Display Assignment Schedule (implement logic)

                                System.out.println("Assignment Schedule functionality is not implemented yet.");
                                break;

                            case 3:
                                // Display Exam Schedule

                                break;

                            default:
                                System.out.println("Invalid choice");
                        }
                        break;

                    case 3:
                        // See Grade
                        System.out.println("Enter your username:");
                        username = scanner.next();

                        break;

                    case 4:
                        // See Material

                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } else if ("teacher".equalsIgnoreCase(userType)) {
                // Teacher Functionality
                System.out.println("1. Upload Schedule\n  1. Upload Class Schedule\n  2. Upload Assignment Schedule\n  3. Upload Exam Schedule\n2. Upload Grade\n3. Upload Material\nEnter your choice:");
                int teacherChoice = scanner.nextInt();


                switch (teacherChoice) {
                    case 1:
                        // Upload Schedule
                        System.out.println("1. Upload Class Schedule\n  2. Upload Assignment Schedule\n  3. Upload Exam Schedule\nEnter your choice:");
                        int scheduleChoice = scanner.nextInt();

                        switch (scheduleChoice) {
                            case 1:
                                // Upload Class Schedule

                                break;

                            case 2:
                                // Upload Assignment Schedule

                                break;

                            case 3:
                                // Upload Exam Schedule

                                break;


                            default:
                                System.out.println("Invalid choice");
                        }
                        break;

                    case 2:
                        // Upload Grade

                        break;

                    case 3:

                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } else {
                System.out.println("Invalid user type");
            }
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