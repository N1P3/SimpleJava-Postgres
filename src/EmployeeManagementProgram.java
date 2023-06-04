import java.sql.*;
import java.util.Scanner;

public class EmployeeManagementProgram {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USERNAME = "n1p3";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            Employee employee = getEmployeeDetailsFromUser();

            insertEmployee(connection, employee);

            System.out.println("Employee added successfully!");

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Employee getEmployeeDetailsFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter position ID: ");
        int positionId = scanner.nextInt();

        System.out.print("Enter department ID: ");
        int departmentId = scanner.nextInt();

        return new Employee(firstName, lastName, email, phoneNumber, address, positionId, departmentId);
    }

    private static void insertEmployee(Connection connection, Employee employee) throws SQLException {
        String insertQuery = "INSERT INTO employees (first_name, last_name, email, phone_number, address, position_id, department_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getEmail());
        preparedStatement.setString(4, employee.getPhoneNumber());
        preparedStatement.setString(5, employee.getAddress());
        preparedStatement.setInt(6, employee.getPositionId());
        preparedStatement.setInt(7, employee.getDepartmentId());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private static class Employee {
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String address;
        private int positionId;
        private int departmentId;

        public Employee(String firstName, String lastName, String email, String phoneNumber, String address, int positionId, int departmentId) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.positionId = positionId;
            this.departmentId = departmentId;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getAddress() {
            return address;
        }

        public int getPositionId() {
            return positionId;
        }

        public int getDepartmentId() {
            return departmentId;
        }
    }
}