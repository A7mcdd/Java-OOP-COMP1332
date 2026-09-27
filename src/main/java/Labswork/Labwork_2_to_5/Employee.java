package Labswork.Labwork_2_to_5;

import java.util.Date;

public class Employee extends Person {
    private String empNo;
    private Department department;

    public Employee(String firstName, String lastName, Date dateOfBirth, Address address,
                    String mobileNumber, String personalEmail, String empNo, Department department) {
        super(firstName, lastName, dateOfBirth, address, mobileNumber, personalEmail);
        this.empNo = empNo;
        this.department = department;
    }

    public String getEmpNo() { return empNo; }
    public void setEmpNo(String empNo) { this.empNo = empNo; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public double pay() {
        return 0.0;
    }

    @Override
    public String toString() {
        return super.toString() + "Employee No: " + empNo + "\nDepartment: " + department + "\n";
    }
}
