package Labswork.Labwork_2_to_5;

import java.util.Date;

public class CommissionBasedEmployee extends CommissionEmployee {
    private double baseSalary;

    public CommissionBasedEmployee(String firstName, String lastName, Date dateOfBirth, Address address,
                                   String mobileNumber, String personalEmail, String empNo, Department department,
                                   double soldItems, double baseSalary) {
        super(firstName, lastName, dateOfBirth, address, mobileNumber, personalEmail, empNo, department, soldItems);
        if (baseSalary >= 0) this.baseSalary = baseSalary;
        else System.out.println("Invalid base salary!");
    }

    @Override
    public double pay() {
        return baseSalary + super.pay();
    }

    @Override
    public String toString() {
        return super.toString() + "Commission-Based Employee: Base " + baseSalary + " NIS\n";
    }
}
