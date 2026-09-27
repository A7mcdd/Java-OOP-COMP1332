package Labswork.Labwork_2_to_5;
import java.util.*;
import java.text.*;



public class Person {
	
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Address address;
	private String mobileNumber;
	private String personalEmail;
	private String workEmail;
	
	
	//الكونستركتر
	public Person(String firstName, String lastName, Date dateOfBirth, Address address,
            String mobileNumber, String personalEmail) {

		if (isValidName(firstName)) this.firstName = firstName;
		else System.out.println("Invalid first name!");
			
		if (isValidName(lastName)) this.lastName = lastName;
		else System.out.println("Invalid last name!");

		if (isValidDate(dateOfBirth)) this.dateOfBirth = dateOfBirth;
		else System.out.println("Invalid date of birth!");
		
		if (address != null) this.address = address;
		else System.out.println("Invalid address!");

		if (isValidMobile(mobileNumber)) this.mobileNumber = mobileNumber;
		else System.out.println("Invalid mobile number!");

		if (isValidEmail(personalEmail)) this.personalEmail = personalEmail;
		else System.out.println("Invalid personal email!");
		
		this.workEmail = workEmailAuto();
}
	
	
	
	
	
	//getters + setters
	public String getFirstName() {
		return firstName; }
    public void setFirstName(String name) {
        if (isValidName(name)) this.firstName = name;
        else System.out.println("Invalid name.");
    }
    
    public String getLastName() {
    	return lastName; }
    public void setLastName(String name) {
        if (isValidName(name)) this.lastName = name;
        else System.out.println("Invalid name.");
    }
    
    
    public Date getDateOfBirth() {
    	return dateOfBirth; }
    public void setDateOfBirth(Date date) {
        if (isValidDate(date)) this.dateOfBirth = date;
        else System.out.println("Invalid date.");
    }
    
    
    
    public Address getAddress() {
    	return address; }
    public void setAddress(Address address) {
        if (address != null) this.address = address;
        else System.out.println("Invalid address.");
    }
    
    
    public String getMobileNumber() {
    	return mobileNumber; }
    public void setMobileNumber(String mobile) {
        if (isValidMobile(mobile)) this.mobileNumber = mobile;
        else System.out.println("Invalid mobile number.");
    }

    public String getPersonalEmail() {
    	return personalEmail; }
    public void setPersonalEmail(String email) {
        if (isValidEmail(email)) this.personalEmail = email;
        else System.out.println("Invalid email.");
    }

    public String getWorkEmail() {
    	return workEmail; }
    
    //isVaild methods
    
    private boolean isValidName(String name) {
        if (name == null || name.length() == 0) return false;
        
        
        // تحقق لو الاسم احرف بس
        for (int i = 1; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')))
                return false;
        }
        return true;
    }
    
    // تحقق تبع العنوان
    private boolean isValidDate(Date date) {
        if (date == null) return false;

        Calendar c = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.setTime(date);
        
        if (birth.after(c)) return false;
        int age = c.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (age < 20) return false;

        return true;
    }
    //تحقق الرقم
    private boolean isValidMobile(String mobile) {
        if (mobile == null || mobile.length() != 9) return false;
        if (!(mobile.startsWith("059") || mobile.startsWith("056"))) return false;
        for (int i = 0; i < mobile.length(); i++) {
            if (mobile.charAt(i) < '0' || mobile.charAt(i) > '9')
                return false;
        }
        return true;
    }

    
    
    // تحقق الايميل
    private boolean isValidEmail(String email) {
        if (email == null) return false;

        int at = email.indexOf("@");
        int dot = email.lastIndexOf(".");

        if (at < 1 || dot < at + 2 || dot == email.length() - 1)
            return false;
        // تقسييم الايميل لاجزاء
        String username = email.substring(0, at);
        String domain = email.substring(at + 1, dot);
        String extension = email.substring(dot + 1);
        // تحقق ما في غير الاحرف العادية
        char first = username.charAt(0);
        if (!(first >= 'A' && first <= 'Z') && !(first >= 'a' && first <= 'z'))
            return false;

        for (int i = 1; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!Character.isLetterOrDigit(c))
                return false;
        }
        //  تحقق الدومين للايميل
        String[] validDomains = {"gmail", "hotmail", "outlook", "yahoo", "birzeit"};
        boolean domainOk = false;
        for (int i = 0; i < validDomains.length; i++) {
            if (domain.equals(validDomains[i])) {
                domainOk = true;
                break;
            }
        }
        // تحقق تبع الامتداد للايميل
        String[] validExt = {"com", "edu", "org", "net"};
        boolean extOk = false;
        for (int i = 0; i < validExt.length; i++) {
            if (extension.equals(validExt[i])) {
                extOk = true;
                break;
            }
        }
        // هون لو الدومين والامتداد صحيحين برجعلنا ترو لو لا فبرجع فولس
        return domainOk && extOk;
    }

    
    // auto email
    private String workEmailAuto() {
        return firstName.toLowerCase().charAt(0) + lastName.toLowerCase() + "@company.com";
    }
    
    
    public double paymentMethod() {
        return 0.0;
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
    	// TODO Auto-generated method stub
    	return super.equals(obj);
    }
    
    @Override
    //to string
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return "Person Info:\n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "DOB: " + df.format(dateOfBirth) + "\n" +
                "Address: " + address + "\n" +
                "Mobile: " + mobileNumber + "\n" +
                "Personal Email: " + personalEmail + "\n" +
                "Work Email: " + workEmail + "\n";
    }
    
    
    
    
	
	
	
    
	
	
	
	
	
	
	
	
	
	
	
	
	

}
