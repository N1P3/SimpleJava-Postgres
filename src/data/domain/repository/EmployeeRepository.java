package data.domain.repository;

import data.domain.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    boolean addNewEmployee(Employee employee);

    List<Employee> getEmployeeList();
}
