package Labswork.Labwork_2_to_5;

import java.text.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Person> persons = new ArrayList<>();

        Department dep1 = new Department("IT", 101);
        Department dep2 = new Department("HR", 102);
        Department dep3 = new Department("Sales", 103);
        Department dep4 = new Department("Finance", 104);
        Department dep5 = new Department("Support", 105);

        Address addr = new Address("West Bank", "Ramallah", "Main Street");

        persons.add(new HourlyEmployee("Ahmad", "Odeh", df.parse("01/01/1999"), addr,
                "059123456", "ahmad12@gmail.com", "E001", dep1, (short)150, 25f));

        persons.add(new WeeklyEmployee("Lina", "Samer", df.parse("12/12/1998"), addr,
                "056123456", "lina22@yahoo.com", "E002", dep2, (byte)4, 500f));

        persons.add(new SalariedEmployee("Ali", "Hamad", df.parse("12/12/1995"), addr,
                "059123457", "ali33@outlook.com", "E003", dep3, 36000));

        persons.add(new ContractEmployee("Sara", "Ziad", df.parse("12/12/1994"), addr,
                "056123458", "sara23@hotmail.com", "E004", dep4, 8000, (byte)8));

        persons.add(new CommissionBasedEmployee("Mohammed", "Ali", df.parse("12/12/1990"), addr,
                "059123459", "mohammed9@birzeit.edu", "E005", dep5, 25000, 2000));

        System.out.println("=== Employee Information ===\n");
        for (Person p : persons) {
            System.out.println(p);
            if (p instanceof Employee)
                System.out.println("Monthly Pay: " + ((Employee)p).pay() + " NIS\n");
        }
    }
}

