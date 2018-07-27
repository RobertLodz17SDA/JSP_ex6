package pl.sdacademy.model;

public class Museum {

    private String id;
    private String name;
    private String postalCode;
    private String city;
    private String streetPrefix;
    private String street;
    private String houseNumber;
    private String flatNumber;
    private String organizer;
    private String entryDate;
    private String status;

    public Museum(String id,
                  String name,
                  String postalCode,
                  String city,
                  String streetPrefix,
                  String street,
                  String houseNumber,
                  String flatNumber,
                  String organizer,
                  String entryDate,
                  String status) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.city = city;
        this.streetPrefix = streetPrefix;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.organizer = organizer;
        this.entryDate = entryDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetPrefix() {
        return streetPrefix;
    }

    public void setStreetPrefix(String streetPrefix) {
        this.streetPrefix = streetPrefix;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
