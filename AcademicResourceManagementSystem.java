
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
                        System.out.println("Student Registration - Enter your username:");
                        username = scanner.next();
                        System.out.println("Enter your password:");
                        String password = scanner.next();
                        registerStudent(connection, username, password);
                        System.out.println("Registration successful!");
                        break;


                    case 2:
                        // See Schedule for Student
                        System.out.println("1. Class Schedule\n2. Assignment Schedule\n3. Exam Schedule\nEnter your choice:");
                        int scheduleType = scanner.nextInt();

                        switch (scheduleType) {
                            case 1:
                                // Display Class Schedule
                                viewClassScheduleForStudent(connection);
                                break;

                            case 2:
                                // Display Assignment Schedule (implement logic)

                                viewAssignmentScheduleForStudent(connection);
                                System.out.println("Assignment Schedule functionality is not implemented yet.");
                                break;

                            case 3:
                                // Display Exam Schedule

                                viewExamScheduleForStudent(connection);

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
                                uploadExamSchedule(connection);
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

    private static void viewClassScheduleForStudent(Connection connection) throws SQLException {
        // Implement logic to retrieve and display class schedule for students from the database
        // Use PreparedStatement to execute queries
        String selectClassScheduleQuery = "SELECT subject, days, class_time FROM class_schedule";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectClassScheduleQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            System.out.println("Class Schedule:");
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No class schedule found.");
            } else {
                System.out.printf("%-15s %-15s %-15s%n", "Subject", "Days", "Class Time");
                while (resultSet.next()) {
                    String subject = resultSet.getString("subject");
                    String classDate = resultSet.getString("days");
                    String classTime = resultSet.getString("class_time");
                    System.out.printf("%-15s %-15s %-15s%n", subject, classDate, classTime);
                }
            }
        }
    }
    private static void viewAssignmentScheduleForStudent(Connection connection) {
        try {
            // Perform a SELECT query to retrieve assignment schedule from the database
            String query = "SELECT * FROM Assignment_Schedule";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Display the assignment schedule in a table form
                System.out.printf("%-15s %-15s %-15s%n", "Subject", "Start Date", "Deadline");
                System.out.println("--------------------------------------------------");

                while (resultSet.next()) {
                    String subject = resultSet.getString("subject");
                    String startDate = resultSet.getString("start_date");
                    String deadline = resultSet.getString("deadline");

                    System.out.printf("%-15s %-15s %-15s%n", subject, startDate, deadline);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching assignment schedule");
        }
    }



    private static void uploadExamSchedule(Connection connection) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get input from the user
            System.out.println("Enter subject:");
            String subject = scanner.nextLine();

            System.out.println("Enter exam name:");
            String examName = scanner.nextLine();

            System.out.println("Enter exam date (yyyy-MM-dd):");
            String examDateStr = scanner.nextLine();
            LocalDate examDate = LocalDate.parse(examDateStr);

            System.out.println("Enter exam time:");
            String examTime = scanner.nextLine();

            // Prepare and execute SQL statement to insert data into exam_schedule table
            String insertQuery = "INSERT INTO exam_schedule (subject, exam_name, exam_date, exam_time) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, subject);
                preparedStatement.setString(2, examName);
                preparedStatement.setDate(3, Date.valueOf(examDate));
                preparedStatement.setString(4, examTime);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Exam schedule uploaded successfully.");
                } else {
                    System.out.println("Failed to upload exam schedule.");
                }
            }
        } catch (SQLException | DateTimeParseException e) {
            e.printStackTrace();
            System.out.println("Error uploading exam schedule.");
        } finally {
            scanner.close();
        }
    }


    private static void viewExamScheduleForStudent(Connection connection) {
        try {
//        // Perform a SELECT query to retrieve exam schedule from the database
            String query = "SELECT * FROM exam_schedule";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

//            // Display the exam schedule in a table form
                System.out.printf("%-15s %-15s %-15s %-15s%n", "Subject", "Exam Name", "Exam Date", "Exam Time");
                System.out.println("-----------------------------------------------------------");

                while (resultSet.next()) {
                    String subject = resultSet.getString("subject");
                    String examName = resultSet.getString("exam_name");
                    String examDate = resultSet.getString("exam_date");
                    String examTime = resultSet.getString("exam_time");

                    System.out.printf("%-15s %-15s %-15s %-15s%n", subject, examName, examDate, examTime);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching exam schedule");
        }
    }


    private static void registerStudent(Connection connection, String username, String password) throws SQLException {
        String insertUserQuery = "INSERT INTO users (username, password, role) VALUES (?, ?, 'student')";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            System.out.println("Student registration successful!");
        }
    }





}