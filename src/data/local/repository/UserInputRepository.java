package data.local.repository;

import data.domain.datasource.InputDataSource;
import data.domain.model.Employee;
import data.domain.repository.InputRepository;

public class UserInputRepository implements InputRepository {
    InputDataSource dataSource;

    public UserInputRepository(InputDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Employee getInput() {
        return dataSource.getEmployee();
    }
}
