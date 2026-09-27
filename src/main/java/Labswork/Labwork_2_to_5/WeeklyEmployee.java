package Labswork.Labwork_2_to_5;

import java.util.Date;

public class WeeklyEmployee extends Employee {
    private byte noOfWeeks;
    private float wagePerWeek;

    public WeeklyEmployee(String firstName, String lastName, Date dateOfBirth, Address address,
                          String mobileNumber, String personalEmail, String empNo, Department department,
                          byte noOfWeeks, float wagePerWeek) {
        super(firstName, lastName, dateOfBirth, address, mobileNumber, personalEmail, empNo, department);
        if (noOfWeeks >= 1 && noOfWeeks <= 4) this.noOfWeeks = noOfWeeks;
        else System.out.println("Invalid number of weeks!");
        if (wagePerWeek >= 300 && wagePerWeek <= 700) this.wagePerWeek = wagePerWeek;
        else System.out.println("Invalid wage per week!");
    }

    public double pay() { return noOfWeeks * wagePerWeek; }

    @Override
    public String toString() {
        return super.toString() + "Weekly Employee: " + noOfWeeks + " weeks × " + wagePerWeek + " NIS\n";
    }
}
