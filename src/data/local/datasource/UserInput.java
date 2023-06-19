package data.local.datasource;

import data.domain.datasource.InputDataSource;
import data.domain.model.Employee;

import java.util.Scanner;

public class UserInput implements InputDataSource {
    @Override
    public Employee getEmployee() {
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
        return new Employee(firstName, lastName,email,phoneNumber,address,positionId,departmentId);
    }
}
