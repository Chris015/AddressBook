package se.nackademin.christopherolsson.adressbook.registries;

import java.io.Serializable;

public class ContactDetails implements Serializable {
    private String firstName;
    private String lastName;
    private String eMailAddress;

    public ContactDetails(String firstName, String lastName, String eMailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMailAddress = eMailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return eMailAddress;
    }
}
