package Labs.Lab03;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Act2 {

	public static void main(String[] args) {
		String[] months = {"January" , "February" , "March" , "April" , "May" , "June" , "July" , "August" , "September" , "October" , "November" , "December"};

		Calendar today = new GregorianCalendar();
		Calendar frstDay = new GregorianCalendar(today.get(Calendar.YEAR),today.get(Calendar.MONTH),1);
		int month = frstDay.get(Calendar.MONTH);
		int year = frstDay.get(Calendar.YEAR);
		int sp = frstDay.get(Calendar.DAY_OF_WEEK)-1;//when we start
		int monthdays = frstDay.getActualMaximum(Calendar.DAY_OF_MONTH);

		System.out.println("\t"+months[month]+" "+year);
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");

		for(int i =0;i<sp;i++) {//المسافة البادئة
			System.out.print("     ");
		}

		for (int day = 1; day <= monthdays; day++) {
			if(day<10)
				System.out.print(" ");

			System.out.print(" "+(day)+" ");

			if((day+sp+1)%7==0)
				System.out.println();
		}
	}

}
