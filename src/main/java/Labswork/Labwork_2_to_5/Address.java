package Labswork.Labwork_2_to_5;

public class Address {
    private String state;
    private String city;
    private String street;

    public Address(String state, String city, String street) {
        if (isValid(state) && isValid(city) && isValid(street)) {
            this.state = state;
            this.city = city;
            this.street = street;
        } else {
            System.out.println("Invalid address input!");
        }
    }

    private boolean isValid(String s) {
        if (s == null || s.trim().isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetter(c) && c != ' ') return false;
        }
        return true;
    }

    public String getState() { return state; }
    public String getCity() { return city; }
    public String getStreet() { return street; }

    public void setState(String state) {
        if (isValid(state)) this.state = state;
        else System.out.println("Invalid state name!");
    }

    public void setCity(String city) {
        if (isValid(city)) this.city = city;
        else System.out.println("Invalid city name!");
    }

    public void setStreet(String street) {
        if (isValid(street)) this.street = street;
        else System.out.println("Invalid street name!");
    }

    @Override
    public String toString() {
        return state + ", " + city + ", " + street;
    }
}
