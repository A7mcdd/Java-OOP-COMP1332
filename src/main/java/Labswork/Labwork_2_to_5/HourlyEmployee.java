package Labswork.Labwork_2_to_5;

import java.util.Date;

public class HourlyEmployee extends Employee {
    private short hours;
    private float rate;

    public HourlyEmployee(String firstName, String lastName, Date dateOfBirth, Address address,
                          String mobileNumber, String personalEmail, String empNo, Department department,
                          short hours, float rate) {
        super(firstName, lastName, dateOfBirth, address, mobileNumber, personalEmail, empNo, department);
        if (hours >= 1 && hours <= 288) this.hours = hours;
        else System.out.println("Invalid hours (1–288)!");
        if (rate >= 8 && rate <= 30) this.rate = rate;
        else System.out.println("Invalid rate (8–30 NIS)!");
    }

    public double pay() {
        if (hours > 120)
            return (120 * rate) + ((hours - 120) * rate * 1.5);
        else
            return hours * rate;
    }

    @Override
    public String toString() {
        return super.toString() + "Hourly Employee: " + hours + " h × " + rate + " NIS\n";
    }
}
