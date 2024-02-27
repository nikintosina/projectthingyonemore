public class Address {
    private String houseNumber;
    private String streetName;
    private String apartmentNumber;
    private String city;
    private String state;
    private String zipCode;

    public Address(String houseNumber, String streetName, String apartmentNumber, String city, String state, String zipCode) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(Address other) {
        this(other.houseNumber, other.streetName, other.apartmentNumber, other.city, other.state, other.zipCode);
    }

    public Address(String fullAddress) {
        String[] parts = fullAddress.split(", ");
        String[] houseAndStreet = parts[0].split(" ", 2);
        this.houseNumber = houseAndStreet[0];
        this.streetName = houseAndStreet[1];
        if (parts.length == 4) {
            this.apartmentNumber = parts[1];
            this.city = parts[2];
            String[] stateZip = parts[3].split(" ");
            this.state = stateZip[0];
            this.zipCode = stateZip[1];
        } else {
            this.apartmentNumber = "";
            this.city = parts[1];
            String[] stateZip = parts[2].split(" ");
            this.state = stateZip[0];
            this.zipCode = stateZip[1];
        }
    }


    public String getHouseNumber() { return houseNumber; }
    public void setHouseNumber(String houseNumber) { this.houseNumber = houseNumber; }
    public String getStreetName() { return streetName; }
    public void setStreetName(String streetName) { this.streetName = streetName; }
    public String getApartmentNumber() { return apartmentNumber; }
    public void setApartmentNumber(String apartmentNumber) { this.apartmentNumber = apartmentNumber; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public String toString() {
        return String.format("%s %s %s, %s, %s %s",
                houseNumber, streetName,
                apartmentNumber.isEmpty() ? "" : "Apt " + apartmentNumber,
                city, state, zipCode);
    }
}
