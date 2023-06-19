package data.remote.repository;

import data.domain.model.Employee;
import data.domain.repository.EmployeeRepository;
import data.remote.datasource.DataBaseConnector;
import data.remote.datasource.EmployeeDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    Connection connection;

    public EmployeeRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return null;
    }

    @Override
    public boolean addNewEmployee(Employee employee) {

        Connection connection = DataBaseConnector.getInstance().connection;
        String insertQuery = "INSERT INTO employees (first_name, last_name, email, phone_number, address, position_id, department_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, employee.firstName);
            preparedStatement.setString(2, employee.lastName);
            preparedStatement.setString(3, employee.email);
            preparedStatement.setString(4, employee.phoneNumber);
            preparedStatement.setString(5, employee.address);
            preparedStatement.setInt(6, employee.positionId);
            preparedStatement.setInt(7, employee.departmentId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
