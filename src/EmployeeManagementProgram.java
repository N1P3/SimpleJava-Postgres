import data.domain.datasource.InputDataSource;
import data.domain.model.Employee;
import data.domain.repository.EmployeeRepository;
import data.domain.repository.InputRepository;
import data.local.datasource.UserInput;
import data.local.repository.UserInputRepository;
import data.remote.datasource.DataBaseConnector;
import data.remote.repository.EmployeeRepositoryImpl;

import java.sql.*;
import java.util.Scanner;

public class EmployeeManagementProgram {


    public static void main(String[] args) {
        InputDataSource inputDataSource = new UserInput();
        InputRepository inputRepository = new UserInputRepository(inputDataSource);
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(DataBaseConnector.getInstance().connection);
        Employee employee = inputRepository.getInput();
        employeeRepository.addNewEmployee(employee);
    }
}