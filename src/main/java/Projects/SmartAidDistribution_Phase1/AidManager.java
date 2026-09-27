package Projects.SmartAidDistribution_Phase1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;


public class AidManager implements FileOperations {
	protected ArrayList<Beneficiary> beneficiaries = new ArrayList<>();
	protected ArrayList<AidItem> aiditems = new ArrayList<>();
	protected ArrayList<DistributionEvent> events = new ArrayList<>();
	protected List<String> cities = Arrays.asList("Gaza", "Rafah", "Khan Younis", "Jerusalem", "Jenin", "Tulkarm", "Hebron", "Ramallah");

	//beneficiaries
	public void addBeneficiary(Beneficiary b) throws DuplicateRegistrationException, CityNotServedException{
		boolean cityFound = false;
		for (String city : cities) {
			if (city.equalsIgnoreCase(b.getCity())) {
				cityFound = true;
				break;
			}
		}

		if (!cityFound) {
			throw new CityNotServedException("City not served. Available cities: " + cities);
		}
		for (Beneficiary exist : beneficiaries) {
			if (exist.equals(b)) throw new DuplicateRegistrationException("Duplicate ID");
		}

		beneficiaries.add(b);
	}

	public void displayBeneficiaries() {
		for (Beneficiary b : beneficiaries)
			System.out.println(b);
	}

	//AidItems
	public void addAidItem(AidItem item) {
		aiditems.add(item);
	}

	public void displayAidItems () {
		for (AidItem a : aiditems)
			System.out.println(a);
	}

	//events
	public void recordDistribution(AidItem item, Beneficiary b, GregorianCalendar date) throws ItemNotFoundException{
		if (!aiditems.contains(item))throw new ItemNotFoundException("Aid item not found");
		events.add(new DistributionEvent(item, b, date));
	}

	public void displayEvents () {
		for (DistributionEvent e : events)
			System.out.println(e);
	}

	//statistical reports
	public void reportFamiliesInCity(String city) {
		int count=0;
		for (DistributionEvent e : events) {
			Beneficiary b = e.getBeneficiary();
			if ( b instanceof Family && b.getCity().equalsIgnoreCase(city)) { 
				count++;}
		}
		System.out.println("Families served in " + city + ": " + count);
	}

	public void reportTotalAidItems() {
		System.out.println("Total aid items distributed: " + events.size());
	}



	public void reportCountByCategory() {

		int foodCount = 0;
		int medicalCount = 0;
		int winterCount = 0;
		int emergencyCount = 0;

		for (DistributionEvent e : events) {
			String cat = e.getItem().getCategory();

			if (cat.equals("Food Package")) foodCount++;
			else if (cat.equals("Medical Kit")) medicalCount++;
			else if (cat.equals("Winter Bag")) winterCount++;
			else if (cat.equals("Emergency Kit")) emergencyCount++;
		}

		System.out.println("Food Packages: " + foodCount);
		System.out.println("Medical Kits: " + medicalCount);
		System.out.println("Winter Bags: " + winterCount);
		System.out.println("Emergency Kits: " + emergencyCount);
	}


	public void reportBeneficiariesBetweenDates(GregorianCalendar start, GregorianCalendar end) {
		for (DistributionEvent e : events) {
			GregorianCalendar d = e.getDate();

			if ((d.after(start) || d.equals(start)) && (d.before(end)  || d.equals(end))) {

				System.out.println(e.getBeneficiary());
			}
		}
	}

	public void reportMostServedCity() {
		if (events.isEmpty()) { // بتحقق لو ما في افينيتز
			System.out.println("No distribution events recorded yet.");
			return;
		}

		String mostCity = "";
		int max = 0;
		for (String city : cities) {
			int count = 0;
			
			
			for (DistributionEvent e : events) {
				if (e.getBeneficiary().getCity().equalsIgnoreCase(city)) {
					count++;
				}
			}

			if (count > max) {
				max = count;
				mostCity = city;
			}
			// لو كل المدن صفر
			if (max == 0) {
				System.out.println("No city has been served yet.");
				return;
			}
//			//  في حال تساوو اكثر من مدينة باكبر عدد
//			ArrayList<String> topCities = new ArrayList<>();
//			for (String cityM : cities) {
//				int countM = 0;
//				for (DistributionEvent e : events) {
//					if (e.getBeneficiary().getCity().equalsIgnoreCase(cityM)) {
//						count++;
//					}
//				}
//				if (countM == max) {
//					topCities.add(cityM);
//				}
//			}
//
//			if (topCities.size() == 1) {
//				System.out.println("Most served city: " + topCities.get(0) + " (" + max + " events)");
//			} else {
//				System.out.print("Most served cities (tied): ");
//				for (int i = 0; i < topCities.size(); i++) {
//					System.out.print(topCities.get(i));
//					if (i < topCities.size() - 1) {
//						System.out.print(", ");
//					}
//				}
//				System.out.println(" (" + max + " events each)");
//			}
		}

		System.out.println("Most served city: " + mostCity + " (" + max + " events)");
	}

















	//text file
	@Override
	public void saveToTextFile(String filename) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

		writer.write("=== BENEFICIARIES ===\n");
		for (Beneficiary b : beneficiaries) {
			writer.write(b.toString() + "\n");
		}

		writer.write("\n=== AID ITEMS ===\n");
		for (AidItem item : aiditems) {
			writer.write(item.toString() + "\n");
		}

		writer.write("\n=== EVENTS ===\n");
		for (DistributionEvent e : events) {
			writer.write(e.toString() + "\n");
		}

		writer.close();
	}

	@Override
	public void loadFromTextFile(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	}

	//binary file
	@Override
	public void saveToBinaryFile(String filename) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(beneficiaries);
			oos.writeObject(aiditems);
			oos.writeObject(events);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public void loadFromBinaryFile(String filename) throws IOException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			try {
				beneficiaries = (ArrayList<Beneficiary>) ois.readObject();
				aiditems = (ArrayList<AidItem>) ois.readObject();
				events = (ArrayList<DistributionEvent>) ois.readObject();
			} catch (ClassNotFoundException e) { e.printStackTrace(); }
		}
	}




}
