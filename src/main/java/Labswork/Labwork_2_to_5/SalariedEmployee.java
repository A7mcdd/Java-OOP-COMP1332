package Labswork.Labwork_2_to_5;

import java.util.Date;

public class SalariedEmployee extends Employee {
    private double annualSalary;

    public SalariedEmployee(String firstName, String lastName, Date dateOfBirth, Address address,
                            String mobileNumber, String personalEmail, String empNo, Department department,
                            double annualSalary) {
        super(firstName, lastName, dateOfBirth, address, mobileNumber, personalEmail, empNo, department);
        if (annualSalary >= 21600 && annualSalary <= 120000)
            this.annualSalary = annualSalary;
        else
            System.out.println("Invalid annual salary!");
    }

    public double pay() { return annualSalary / 12; }

    @Override
    public String toString() {
        return super.toString() + "Salaried Employee: Annual " + annualSalary + " NIS\n";
    }
}
