package Labswork.Labwork_2_to_5;

import java.util.Date;

public class ContractEmployee extends Employee {
    private double rateOfContract;
    private byte months;

    public ContractEmployee(String firstName, String lastName, Date dateOfBirth, Address address,
                            String mobileNumber, String personalEmail, String empNo, Department department,
                            double rateOfContract, byte months) {
        super(firstName, lastName, dateOfBirth, address, mobileNumber, personalEmail, empNo, department);
        if (rateOfContract > 0 && rateOfContract <= 10000) this.rateOfContract = rateOfContract;
        else System.out.println("Invalid contract rate!");
        if (months > 0) this.months = months;
        else System.out.println("Invalid number of months!");
    }

    public double pay() { return rateOfContract / months; }

    @Override
    public String toString() {
        return super.toString() + "Contract Employee: Rate " + rateOfContract + " / " + months + " months\n";
    }
}
