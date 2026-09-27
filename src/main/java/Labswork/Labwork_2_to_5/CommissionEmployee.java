package Labswork.Labwork_2_to_5;

import java.util.Date;

public class CommissionEmployee extends Employee {
    private double soldItems;

    public CommissionEmployee(String firstName, String lastName, Date dateOfBirth, Address address,
                              String mobileNumber, String personalEmail, String empNo, Department department,
                              double soldItems) {
        super(firstName, lastName, dateOfBirth, address, mobileNumber, personalEmail, empNo, department);
        if (soldItems >= 0) this.soldItems = soldItems;
        else System.out.println("Invalid sales amount!");
    }

    public double pay() {
        if (soldItems < 15000) return soldItems * 0.015;
        else if (soldItems <= 20000) return soldItems * 0.03;
        else return soldItems * 0.05;
    }

    @Override
    public String toString() {
        return super.toString() + "Commission Employee: Sold " + soldItems + " NIS\n";
    }
}
