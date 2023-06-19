package data.domain.model;
public class Employee {
    public final String firstName;
    public final String lastName;
    public final String email;
    public final String phoneNumber;
    public final String address;
    public final int positionId;
    public final int departmentId;

    public Employee(String firstName, String lastName, String email, String phoneNumber, String address, int positionId, int departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.positionId = positionId;
        this.departmentId = departmentId;
    }

}

